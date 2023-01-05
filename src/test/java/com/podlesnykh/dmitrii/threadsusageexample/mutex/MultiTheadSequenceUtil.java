package com.podlesnykh.dmitrii.threadsusageexample.mutex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MultiTheadSequenceUtil {

    public Set<Integer> getUniqueSequences(SequenceGenerator sequenceGenerator,
                                           int count) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();



        IntStream.range(0, count)
                .forEach(v -> {
                    Future<Integer> future = executorService.submit(sequenceGenerator::getNextSequence);
                    futures.add(future);
                });

        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
        return uniqueSequences;
    }
}
