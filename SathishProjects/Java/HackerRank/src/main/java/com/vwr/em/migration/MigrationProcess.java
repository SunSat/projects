package com.vwr.em.migration;

import com.vwr.em.migration.dao.manager.PersistanceManager;
import com.vwr.em.migration.dao.service.DocumentService;
import com.vwr.em.migration.dao.service.DocumentServiceImpl;
import com.vwr.em.migration.util.JCRFileUtil;
import com.vwr.em.migration.taskData.MigrationTask;
import com.vwr.em.migration.taskExecutor.*;
import com.vwr.em.migration.threadCommunicator.DownloadCycleBarrier;
import com.vwr.em.migration.util.PropertyUtil;
import  static com.vwr.em.migration.util.MigrationConstants.*;

import com.vwr.em.migration.util.ShutdownExecutor;
import org.apache.log4j.Logger;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class MigrationProcess {

    private static Logger logger = Logger.getLogger(MigrationProcess.class.getClass());

    public static void main(String[] args) {
        MigrationProcess process = new MigrationProcess();
        process.testDownload();
    }

    public void testDownload() {
        logger.debug("Hello Mapping");

        JCRFileUtil jcrFactory = null;
        javax.jcr.Session jcrSession = null;

        try {
            jcrFactory = JCRFileUtil.getInstance();
            logger.debug("JCR initiatted.");
            jcrSession = jcrFactory.getSession();
        } catch (RepositoryException e) {
            logger.error("JCR Init failled in MigrationProcess. :", e);
        } catch (NamingException e) {
            logger.error("JCR Init failled in MigrationProcess. :", e);
        }

        if(jcrSession == null) {
            logger.debug("error while initialting JCR. Hence exiting from app.");
            return;
        }
        PersistanceManager manager = null;
        DocumentService service = null;
        try {
            manager = PersistanceManager.getInstance();
            service = new DocumentServiceImpl();
        } catch (Exception e) {
            logger.error("Hibernate Database initialization failled. Existing app ",  e);
        }

        if(manager == null) {
            logger.debug("error while initialting ORM. Hence exiting from app.");
            return;
        }

        String readType = PropertyUtil.getProperty(MIGRATION_TYPE);
        String maxRecordToProcess = PropertyUtil.getProperty(MIGRATION_MAX_RECORD_LIMIT);
        Integer downloadThreadCount = Integer.parseInt(PropertyUtil.getProperty(MIGRATION_DOWNLOAD_THREAD_COUNT));
        Integer uploadThreadCount = Integer.parseInt(PropertyUtil.getProperty(MIGRATION_UPLOAD_THREAD_COUNT));
        String downloadFilePath = PropertyUtil.getProperty(MIGRATION_DOWNLOAD_FILE_PATH);

        BlockingQueue<MigrationTask> downloadQueue = new LinkedBlockingQueue<>();
        BlockingQueue<MigrationTask> downloadCompletedQueue = new LinkedBlockingQueue<>();
        BlockingQueue<MigrationTask> uploadQueue = new LinkedBlockingQueue<>();
        BlockingQueue<MigrationTask> dbUpdateQueue = new LinkedBlockingQueue<>();

        int n = 3;

        DownloadCycleBarrier downloadCycleBarrier = new DownloadCycleBarrier(n);

        List<MigrationTaskExecutor> allTaskExecutor = new ArrayList<>();

        DBReadTaskExecutor dbReadExecutor = new DBReadTaskExecutor(readType,maxRecordToProcess,null,downloadQueue,downloadCycleBarrier,service);
        allTaskExecutor.add(dbReadExecutor);
        dbReadExecutor.start();

        for(Integer i=0;i<n-1;i++) {
            String threadName = "DownloadExector" + i;
            DownloadTaskExecutor downLoadTaskExecutor = new DownloadTaskExecutor(downloadQueue,downloadCompletedQueue,threadName,downloadCycleBarrier,jcrSession);
            allTaskExecutor.add(downLoadTaskExecutor);
            downLoadTaskExecutor.start();
        }

        Runtime.getRuntime().addShutdownHook(new ShutdownTaskExecutor(null,null,allTaskExecutor));
        try {
            dbReadExecutor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().exit(1);

        /*TransferTaskExector transferTaskExector = new TransferTaskExector(downloadCompletedQueue,uploadQueue,"TransferTaskExector");
        allTaskExecutor.add(transferTaskExector);
        transferTaskExector.start();

        for(Integer i=0;i<uploadThreadCount;i++) {
            String thName = "UploadExecutor" + 1;
            UploadTaskExecutor uploadTaskExecutor = new UploadTaskExecutor(uploadQueue,dbUpdateQueue,thName);
            allTaskExecutor.add(uploadTaskExecutor);
            uploadTaskExecutor.start();
        }

        DBUpdateTaskExecutor dbUpdateTaskExecutor = new DBUpdateTaskExecutor(dbUpdateQueue,null,service);
        allTaskExecutor.add(dbUpdateTaskExecutor);
        dbUpdateTaskExecutor.start();
*/

    }

    public void updateload() {
        JCRFileUtil jcrFactory = null;
        javax.jcr.Session jcrSession = null;

        try {
            jcrFactory = JCRFileUtil.getInstance();
            logger.debug("JCR initiatted.");
            jcrSession = jcrFactory.getSession();
        } catch (RepositoryException e) {
            logger.error("JCR Init failled in MigrationProcess. :", e);
        } catch (NamingException e) {
            logger.error("JCR Init failled in MigrationProcess. :", e);
        }

        if(jcrSession == null) {
            logger.debug("error while initialting JCR. Hence exiting from app.");
            return;
        }

        PersistanceManager manager = null;
        DocumentService service = null;
        try {
            manager = PersistanceManager.getInstance();
            service = new DocumentServiceImpl();
        } catch (Exception e) {
            logger.error("Hibernate Database initialization failled. Existing app ",  e);
        }

        if(manager == null) {
            logger.debug("error while initialting ORM. Hence exiting from app.");
            return;
        }


        List<MigrationTaskExecutor> allTaskExecutor = new ArrayList<>();

        String readType = PropertyUtil.getProperty(MIGRATION_TYPE);
        String maxRecordToProcess = PropertyUtil.getProperty(MIGRATION_MAX_RECORD_LIMIT);
        Integer downloadThreadCount = Integer.parseInt(PropertyUtil.getProperty(MIGRATION_DOWNLOAD_THREAD_COUNT));

        BlockingQueue<MigrationTask> uploadQueue = new LinkedBlockingQueue<>();

        int n = 2;
        DownloadCycleBarrier downloadCycleBarrier = new DownloadCycleBarrier(n);

        DBReadTaskExecutor dbReadExecutor = new DBReadTaskExecutor(readType,maxRecordToProcess,null,uploadQueue,downloadCycleBarrier,service);
        allTaskExecutor.add(dbReadExecutor);
        dbReadExecutor.start();

        JCRUploadTaskExecutor uploadTaskExecutor = null;
        for(int i=0;i<n-1;i++) {
            Session ses = JCRFileUtil.getNewSession();
            uploadTaskExecutor = new JCRUploadTaskExecutor(uploadQueue, null,"download" + i,downloadCycleBarrier,ses,service);
            allTaskExecutor.add(uploadTaskExecutor);
            uploadTaskExecutor.start();
        }

        Runtime.getRuntime().addShutdownHook(new ShutdownTaskExecutor(null,null,allTaskExecutor));
        try {
            dbReadExecutor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().exit(1);
    }
}
