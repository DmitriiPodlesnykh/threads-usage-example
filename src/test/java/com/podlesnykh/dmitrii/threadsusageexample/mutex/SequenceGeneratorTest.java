package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SequenceGeneratorTest {

    @Test
    void getNextSequence_incorrectCalculation() throws ExecutionException, InterruptedException {
        int count = 10_000;

        MultiTheadSequenceUtil multiTheadSequenceUtil = new MultiTheadSequenceUtil();
        Set<Integer> integers = multiTheadSequenceUtil.getUniqueSequences(new SequenceGenerator(), count);
        assertNotEquals(count, integers.size());
    }
}