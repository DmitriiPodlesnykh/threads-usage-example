package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import java.util.concurrent.Semaphore;

public class SequenceGeneratorUsingSemaphore extends SequenceGenerator {

    private final Semaphore mutex = new Semaphore(1);

    @Override
    public int getNextSequence() {
        try {
            mutex.acquire();
            return super.getNextSequence();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            mutex.release();
        }
    }
}
