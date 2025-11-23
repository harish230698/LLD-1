package org.learning.concurrency1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency {

    public static void main(String[] args) {

        /*
        * The below code is inefficient as we are creating the new thread
        * every time for printing an element
        * */

        for(int i=1;i<=100;i++){
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread thread = new Thread(numberPrinter);
            thread.start();
        }
    }
}
