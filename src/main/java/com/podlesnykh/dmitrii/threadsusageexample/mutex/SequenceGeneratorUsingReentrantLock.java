package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import java.util.concurrent.locks.ReentrantLock;

public class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {

    private final ReentrantLock mutex = new ReentrantLock();

    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        }
        finally {
            mutex.unlock();
        }
    }
}
