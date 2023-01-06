package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MultiTheadSequenceUtil {

    public static final int COUNT_ITERATIONS = 1_000_000;

    public Set<Integer> getUniqueSequences(final SequenceGenerator sequenceGenerator,
                                           final int count) throws InterruptedException, ExecutionException {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        final List<Future<Integer>> futures = prepareFutures(sequenceGenerator, count,  executorService);
        final Set<Integer> uniqueSequences = getFuturesResults(futures);
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
        return uniqueSequences;
    }

    private List<Future<Integer>> prepareFutures(final SequenceGenerator sequenceGenerator,
                                                 final int count,
                                                 final ExecutorService executorService) {
        final List<Future<Integer>> futures = new ArrayList<>();
        IntStream.range(0, count).forEach(v -> {
            Future<Integer> future = executorService.submit(sequenceGenerator::getNextSequence);
            futures.add(future);
        });
        return futures;
    }

    private Set<Integer> getFuturesResults(List<Future<Integer>> futures)
            throws ExecutionException, InterruptedException {
        final Set<Integer> uniqueSequences = new LinkedHashSet<>();
        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }
        return uniqueSequences;
    }
}
