package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import com.google.common.util.concurrent.Monitor;
public class SequenceGeneratorUsingMonitor extends SequenceGenerator {

    private final Monitor mutex = new Monitor();

    @Override
    public int getNextSequence() {
        mutex.enter();
        try {
            return super.getNextSequence();
        } finally {
            mutex.leave();
        }
    }
}
