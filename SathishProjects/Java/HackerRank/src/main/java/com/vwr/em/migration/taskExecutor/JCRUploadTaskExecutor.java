package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.dao.DocumentDao;
import com.vwr.em.migration.dao.service.DocumentService;
import com.vwr.em.migration.taskData.MigrationTask;
import com.vwr.em.migration.threadCommunicator.DownloadCycleBarrier;
import com.vwr.em.migration.util.FileUtil;
import com.vwr.em.migration.util.JCRFileUtil;
import com.vwr.em.migration.util.PropertyUtil;
import org.apache.log4j.Logger;

import javax.jcr.Session;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sathishkumar_su on 7/16/2018.
 */
public class JCRUploadTaskExecutor extends MigrationTaskExecutor {


    Session session = null;
    DownloadCycleBarrier barrier = null;
    DocumentService service = null;
    Logger logger = Logger.getLogger("dbreadLogger");
    String clazz = (JCRUploadTaskExecutor.class.getName()).substring(JCRUploadTaskExecutor.class.getName().lastIndexOf(".")+1);

    public JCRUploadTaskExecutor(BlockingQueue<MigrationTask> from, BlockingQueue<MigrationTask> to, String thName,
                                DownloadCycleBarrier barrier,Session session, DocumentService service) {
        super(from, to);
        setName(thName);
        this.session = session;
        this.barrier = barrier;
        this.service = service;
    }

    @Override
    public void run() {
        String basePath = PropertyUtil.getProperty("migrate.testing.folder.upload.paths");
        File file = new File(basePath);
        File[] fileList = file.listFiles();
        int i = 0;
        int counter = 0;
        DocumentDao newDao = null;
        while(!isInterupted || fromQueue.size() > 0) {
            try {
                MigrationTask task = fromQueue.poll(1, TimeUnit.SECONDS);
                if(task != null) {
                    counter++;
                    if(i >= fileList.length) i = 0;
                    File f = fileList[i++];
                    FileInputStream fos = new FileInputStream(f);
                    BufferedInputStream bos = new BufferedInputStream(fos);
                    DocumentDao doDao = task.getDocumentdao();
                    logger.debug(clazz + " : Task with ID " + doDao.getSkGuid() + ", FileName is : " + f.getName() + ", The Org ID is : " + doDao.getOrgId() + ", Final Counter" + counter);
                    try {
                        String fileName = f.getName();
                        String contextType = fileName.substring(fileName.lastIndexOf('.'));
                        newDao = JCRFileUtil.saveFileNode(bos, contextType, "em/service", fileName, doDao, false);
                        newDao.setFileName(fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        service.updateDocumentDao(newDao);
                    } catch (Exception e) {
                        logger.error("Errow while uploading document" + e.getMessage());
                    }
                }
                if(barrier.isCanProceedFruther() && fromQueue.size() == 0) {
                    try {
                        logger.debug(clazz + " :Can Proceed fruther is True. Barrier Waiting option is : " + barrier.getNumberWaiting());
                        barrier.await();
                        barrier.setCanProceedFruther(false);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
