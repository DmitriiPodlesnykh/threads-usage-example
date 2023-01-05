package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SequenceGeneratorUsingSynchronizedMethodTest {

    @Test
    void getNextSequence() throws ExecutionException, InterruptedException {
        int count = 10_000;

        MultiTheadSequenceUtil multiTheadSequenceUtil = new MultiTheadSequenceUtil();
        Set<Integer> integers
                = multiTheadSequenceUtil.getUniqueSequences(new SequenceGeneratorUsingSynchronizedMethod(), count);
        assertEquals(count, integers.size());
    }
}