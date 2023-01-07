package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import static com.podlesnykh.dmitrii.threadsusageexample.mutex.MultiTheadSequenceUtil.COUNT_ITERATIONS;
import static org.junit.jupiter.api.Assertions.*;

class SequenceGeneratorUsingSemaphoreTest {

    private SequenceGeneratorUsingSemaphore sut;

    private MultiTheadSequenceUtil multiTheadSequenceUtil;

    @BeforeEach
    public void setUp() {
        sut = new SequenceGeneratorUsingSemaphore();
        multiTheadSequenceUtil = new MultiTheadSequenceUtil();
    }

    @Test
    void getNextSequence_incorrectCalculation() throws ExecutionException, InterruptedException {

        Set<Integer> integers = multiTheadSequenceUtil.getUniqueSequences(sut, COUNT_ITERATIONS);

        assertEquals(COUNT_ITERATIONS, integers.size());
    }
}