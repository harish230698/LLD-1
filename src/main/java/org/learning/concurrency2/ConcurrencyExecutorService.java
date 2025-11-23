package org.learning.concurrency2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExecutorService {

    public static void main(String[] args) {

        /*
         * The below code is inefficient as we are creating the new thread
         * every time for printing an element
         * */

//        for(int i=1;i<=100;i++){
//            NumberPrinterUsingExecutorService numberPrinter = new NumberPrinterUsingExecutorService(i);
//            Thread thread = new Thread(numberPrinter);
//            thread.start();
//        }

        /*
         * Executor Service manage Threads internally and process the task
         * We can explicitly allocate maximum threads while creating Executor Service
         * */

//        ExecutorService executorService = Executors.newFixedThreadPool(10);


        //CachedThreadPool will assign new of threads internally

            ExecutorService executorService = Executors.newCachedThreadPool();

            for(int i=1;i<=100;i++){
                NumberPrinterUsingExecutorService num = new NumberPrinterUsingExecutorService(i);
                executorService.submit(num);
            }
    }
}
