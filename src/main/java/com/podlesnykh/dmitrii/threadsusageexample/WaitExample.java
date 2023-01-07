package com.podlesnykh.dmitrii.threadsusageexample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.IntStream.range;

public class WaitExample {

    private static final int COUNT_ITERATOR_CONST = 500;

    public int getSumIterationsValues(int countThreads) {
        int result = 0;
        final List<ExampleThread> exampleThreads = new ArrayList<>();
        range(0, countThreads).forEach(value -> exampleThreads.add(new ExampleThread(COUNT_ITERATOR_CONST)));
        for (ExampleThread thread : exampleThreads) {
            thread.start();
        }

        for (ExampleThread thread : exampleThreads) {
            result = result + thread.getLastValue();
        }

        return result;
    }
}


class ExampleThread extends Thread {

    private int value = 0;
    private boolean isDone = false;

    private final int countIterations;

    public ExampleThread(int countIterations) {
        this.countIterations = countIterations;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < countIterations; i++) {
                System.out.println(Thread.currentThread().getName() + ": i = " + i);
                value++;
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isDone = true;
    }

    public int getLastValue() {

        synchronized (this) {
            if (!isDone) {
                System.out.println(Thread.currentThread().getName() + ": getLastValue");
                try {
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + ": getLastValue: isDone = " + isDone);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return value;
    }
}