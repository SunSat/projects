package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.taskData.MigrationTask;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sathishkumar_su on 7/17/2018.
 */
public class ShutdownTaskExecutor extends MigrationTaskExecutor {

    List<MigrationTaskExecutor> executors = null;
    public ShutdownTaskExecutor(BlockingQueue<MigrationTask> from, BlockingQueue<MigrationTask> to, List<MigrationTaskExecutor> allTaskExecutor) {
        super(from, to);
        this.executors = allTaskExecutor;

    }

    @Override
    public void run() {
        for(MigrationTaskExecutor allTask : executors) {
            allTask.setIsInterupted(true);
            //allTask.interrupt();
        }
    }
}
