package com.podlesnykh.dmitrii.threadsusageexample.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceInitializer {

    private static final int CORE_POOL_SIZE = 1;
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final long KEEP_ALIVE_TIME = 0L;
    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    public ExecutorService factoryMethodExample() {
        return Executors.newFixedThreadPool(4);
    }

    public ExecutorService directlyCreateExecutorService() {
        final BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, blockingQueue);
    }
}
