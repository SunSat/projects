package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.taskData.MigrationTask;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class UploadTaskExecutor extends MigrationTaskExecutor {

    public UploadTaskExecutor(BlockingQueue<MigrationTask> from, BlockingQueue<MigrationTask> to,String thName) {
        super(from, to);
        setName(thName);
    }

    @Override
    public void run() {
        while(!isInterupted || fromQueue.size() != 0) {
            try {
                MigrationTask task = fromQueue.poll(1, TimeUnit.SECONDS);
                if(task != null) {
                    //process Uploade data;
                    //update Task TaskDetail.
                    toQueue.offer(task);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
