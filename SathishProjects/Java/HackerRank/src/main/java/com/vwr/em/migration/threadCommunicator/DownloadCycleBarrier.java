package com.vwr.em.migration.threadCommunicator;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by sathishkumar_su on 7/13/2018.
 */
public class DownloadCycleBarrier extends CyclicBarrier {

    AtomicBoolean canProceedFruther = new AtomicBoolean(false);

    public DownloadCycleBarrier(int parties, Runnable barrierAction) {
        super(parties, barrierAction);
    }

    public DownloadCycleBarrier(int parties) {
        super(parties);
    }

    public boolean isCanProceedFruther() {
        return canProceedFruther.get();
    }

    public void setCanProceedFruther(boolean canProceedFruther) {
        if(this.canProceedFruther.get() != canProceedFruther)
            this.canProceedFruther.set(canProceedFruther);
    }
}
