package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.dao.service.DocumentService;
import com.vwr.em.migration.taskData.MigrationTask;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class DBUpdateTaskExecutor extends MigrationTaskExecutor {

    private DocumentService docService = null;

    public DBUpdateTaskExecutor(BlockingQueue<MigrationTask> from, BlockingQueue<MigrationTask> to, DocumentService docService) {
        super(from, to);
        this.docService = docService;
    }

    @Override
    public void run() {
        while(!isInterupted || fromQueue.size() == 0) {
            try {
                MigrationTask task = fromQueue.poll(1, TimeUnit.SECONDS);
                if(task != null) {
                    docService.updateDocumentDao(task.getDocumentdao());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
