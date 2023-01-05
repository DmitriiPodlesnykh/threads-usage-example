package com.podlesnykh.dmitrii.threadsusageexample.mutex;

public class SequenceGeneratorUsingSynchronizedMethod extends SequenceGenerator {

    private final Object mutexObject = new Object();

    @Override
    public int getNextSequence() {
        synchronized (mutexObject) {
            return super.getNextSequence();
        }
    }
}
