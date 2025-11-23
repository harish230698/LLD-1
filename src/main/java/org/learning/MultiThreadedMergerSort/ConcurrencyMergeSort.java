package org.learning.MultiThreadedMergerSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyMergeSort {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(4,2,5,6,1,8,3,7);

        /*
        We are creating Executor Service on Main class and onto the MergeSortCallable Class
        which is inefficient. Which leads to multiple thread pools- each thread pool have multiple threads
        So same Executor Service needs to be shared to MergeSortCallable Class as well
        */

        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSortCallable mergeSortCallable = new MergeSortCallable(list,executorService);
        Future<List<Integer>> sortedList = executorService.submit(mergeSortCallable);

        System.out.println(sortedList.get());

    }
}
