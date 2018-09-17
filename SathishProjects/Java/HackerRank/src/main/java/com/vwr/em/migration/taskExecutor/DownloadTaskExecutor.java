package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.dao.DocumentDao;
import com.vwr.em.migration.taskData.MigrationTask;
import com.vwr.em.migration.threadCommunicator.DownloadCycleBarrier;
import com.vwr.em.migration.util.FileUtil;
import com.vwr.em.migration.util.JCRFileUtil;
import com.vwr.em.migration.util.PropertyUtil;
import org.apache.log4j.Logger;

import javax.jcr.Session;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class DownloadTaskExecutor extends MigrationTaskExecutor {

    Session session = null;
    DownloadCycleBarrier barrier = null;
    Logger logger = Logger.getLogger("downloadLogger");

    public DownloadTaskExecutor(BlockingQueue<MigrationTask> from, BlockingQueue<MigrationTask> to, String thName,
                                DownloadCycleBarrier barrier,Session session) {
        super(from, to);
        setName(thName);
        this.session = session;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        String basePath = PropertyUtil.getProperty("migrate.download.file.path");
        while(!isInterupted || fromQueue.size() != 0) {
            try {
                MigrationTask task = fromQueue.poll(1, TimeUnit.SECONDS);
                if(task != null) {
                    DocumentDao doDao = task.getDocumentdao();
                    String docUniqueId = doDao.getDocumentUniquId();
                    String extDirName = doDao.getFileName();
                    String extension = extDirName.substring(extDirName.lastIndexOf('.')+1);
                    String fullPath = basePath + File.separator + doDao.getOrgId()+File.separator + extension + File.separator + doDao.getFileName();
                    FileUtil.creaateDir(basePath + File.separator + doDao.getOrgId()+File.separator + extension + File.separator);
                    Boolean isFileDownloadSuccess = JCRFileUtil.downloadFile(docUniqueId,doDao,fullPath);
                    task.setDownloadPath(fullPath);
                    task.setCurrentState("uploade");
                    task.setNextState("dbupdate");
                    if(isFileDownloadSuccess) {
                        toQueue.offer(task);
                    }
                    else {
                        logger.debug("Erroe in downloadFile the task ID is : " + task.getTaskId());
                    }
                }
                if(barrier.isCanProceedFruther() && fromQueue.size() == 0) {
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException ie) {
                logger.error("Error while downloading the file " + ie.getMessage());
            } catch (Exception ex) {
                logger.error("Error 1 downloading the file " + ex.getMessage());
            }
        }
    }
}
