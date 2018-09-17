package com.vwr.em.migration.taskExecutor;

import com.vwr.em.migration.taskData.MigrationTask;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class MigrationTaskExecutor extends Thread {

    protected BlockingQueue<MigrationTask> fromQueue = null;
    protected BlockingQueue<MigrationTask> toQueue = null;

    protected boolean isInterupted = false;

    public MigrationTaskExecutor(BlockingQueue<MigrationTask> from,BlockingQueue<MigrationTask> to) {
        this.fromQueue = from;
        this.toQueue = to;
    }

    @Override
    public void run() {

    }

    public boolean isInterupted() {
        return isInterupted;
    }

    public void setIsInterupted(boolean isInterupted) {
        this.isInterupted = isInterupted;
    }
}
