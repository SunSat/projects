package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.dao.DocumentDao;
import com.vwr.em.migration.dao.service.DocumentService;
import com.vwr.em.migration.dao.service.DocumentServiceImpl;
import com.vwr.em.migration.taskData.MigrationTask;
import com.vwr.em.migration.threadCommunicator.DownloadCycleBarrier;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class DBReadTaskExecutor extends MigrationTaskExecutor {

    private String readType;
    private String maxRecordToProcess;
    private List<Integer> idToProcess;
    DownloadCycleBarrier downloadCyBarrier = null;
    private DocumentService docService = null;
    private Logger logger = Logger.getLogger("dbreadLogger");
    String clazz = DBReadTaskExecutor.class.getName().substring(DBReadTaskExecutor.class.getName().lastIndexOf(".")+1);

    public DBReadTaskExecutor(String readType, String maxRecordToProcess,BlockingQueue<MigrationTask> from, BlockingQueue<MigrationTask> to,
                              DownloadCycleBarrier downloadCyBarrier, DocumentService docService) {
        super(from,to);
        logger.debug("Initating DBReadTaskExecutor");
        this.readType = readType;
        this.maxRecordToProcess = maxRecordToProcess;
        this.downloadCyBarrier = downloadCyBarrier;
        this.docService = docService;
        init();
        logger.debug("Successfully initiated DBReadTaskExecutor");
    }

    private void init() {
        if(readType.equals("org")) {
            idToProcess = docService.getUniqueOrgIdFromDocument();
        } else {
            idToProcess = docService.getAllDocumentIds();
        }
    }

    @Override
    public void run() {
        if(readType.equals("org")) {
            for(Integer id : idToProcess) {
                if(isInterupted) {
                    return;
                }
                logger.debug(clazz + " : Starting the Organization id : " + id);
                List<DocumentDao> liDocuments = docService.getAllByOrgId(id);
                if(liDocuments.size() > 0) {
                    for(DocumentDao docObj : liDocuments) {
                        MigrationTask task  = new MigrationTask(docObj.getSkGuid(),"read","download",docObj);
                        toQueue.offer(task);
                        logger.debug(clazz + " : Migration Task with ID : " + task.getTaskId() + "Has been added to uploadJCR task successfully");
                    }
                    logger.debug(clazz + " : Ending Org : " + id + ", Has been processed and added to download queue. and Barrier Waiting size is : " + downloadCyBarrier.getNumberWaiting());
                    try {
                        downloadCyBarrier.setCanProceedFruther(true);
                        long cuTime = System.currentTimeMillis();
                        logger.debug(clazz + " : The download barrier size is : " + downloadCyBarrier.getNumberWaiting() );
                        downloadCyBarrier.await();
                        logger.debug(clazz + " : The waiting for the Org Id is : " + id + ". Milliseconds is : " + (System.currentTimeMillis() -  cuTime) + "The download barrier size is : " + downloadCyBarrier.getNumberWaiting() );
                        downloadCyBarrier.setCanProceedFruther(false);
                        downloadCyBarrier.reset();
                        logger.debug(clazz + " : The barrier after reset size is : " + downloadCyBarrier.getNumberWaiting() );
                    } catch (InterruptedException e) {
                        if(isInterupted) {
                            logger.error("Error in DB ReadTask Executor Error msge is 1  : " +e.getMessage() );
                            return;
                        }
                    } catch (BrokenBarrierException e) {
                        if(isInterupted) {
                            logger.error("Error in DB ReadTask Executor Error msge is 2  : " + e.getMessage());
                            return;
                        }
                    }
                }
            }
        }
    }
}
