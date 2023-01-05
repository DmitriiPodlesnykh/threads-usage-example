package com.podlesnykh.dmitrii.threadsusageexample.mutex;

public class SequenceGenerator {

    private int value = 0;

    public int getNextSequence() {
        value = value + 1;
        return value;
    }
}
