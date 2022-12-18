package com.podlesnykh.dmitrii.threadsusageexample.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    private ExecutorServiceInitializer executorServiceInitializer = new ExecutorServiceInitializer();

    public void assigningTasksToTheExecutorService() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Executed runnable");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Callable<String> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Executed callable";
        };

        List<Callable<String>> callableList = new ArrayList<>();

        for (int i = 0; i< 5; i++) {
            callableList.add(callable);
        }

        ExecutorService executorService = executorServiceInitializer.factoryMethodExample();
        executorService.invokeAll(callableList);

        executorService.execute(runnable);

        executorService.shutdown();
    }

}
