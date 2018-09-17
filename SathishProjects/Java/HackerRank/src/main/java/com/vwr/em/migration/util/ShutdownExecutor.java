package com.vwr.em.migration.util;

import com.vwr.em.migration.taskExecutor.MigrationTaskExecutor;

import java.util.List;

/**
 * Created by sathishkumar_su on 7/16/2018.
 */
public class ShutdownExecutor extends Thread {
    private List<MigrationTaskExecutor> executorList = null;

    public ShutdownExecutor(List<MigrationTaskExecutor> list) {
        this.executorList = list;
    }

    public void run() {
        for(MigrationTaskExecutor executor : executorList) {
            try {
                executor.setIsInterupted(true);
                executor.interrupt();
            } catch (Exception e) {
                System.err.println("Not bothering need to close all the threads" + e.getMessage());
            }
        }
    }
}
