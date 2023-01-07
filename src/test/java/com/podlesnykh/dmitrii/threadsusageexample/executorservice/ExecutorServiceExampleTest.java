package com.podlesnykh.dmitrii.threadsusageexample.executorservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorServiceExampleTest {

    private ExecutorServiceExample sut;

    @BeforeEach
    public void setUp() {
        sut = new ExecutorServiceExample();
    }

    @Test
    void assigningTasksToTheExecutorService() throws InterruptedException {
        sut.assigningTasksToTheExecutorService();
    }
}