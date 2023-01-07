package com.podlesnykh.dmitrii.threadsusageexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitExampleTest {

    private static final int COUNT_ITERATOR_CONST_TEST = 500;

    private WaitExample sut;

    @BeforeEach
    public void setUp() {
        sut = new WaitExample();
    }

    @Test
    void getSumIterationsValues_1Thread_returnConstantValue() {
        int threadCount = 1;

        int result = sut.getSumIterationsValues(threadCount);

        assertEquals(result, COUNT_ITERATOR_CONST_TEST);
    }

    @Test
    void getSumIterationsValues_2Threads_return2TimesMoreConstantValue() {
        int threadCount = 2;

        int result = sut.getSumIterationsValues(threadCount);

        assertEquals(result, threadCount*COUNT_ITERATOR_CONST_TEST);
    }

    @Test
    void getSumIterationsValues_5Threads_return5TimesMoreConstantValue() {
        int threadCount = 50;

        int result = sut.getSumIterationsValues(threadCount);

        assertEquals(result, threadCount*COUNT_ITERATOR_CONST_TEST);
    }
}