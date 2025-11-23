package org.learning.concurrency2;

public class NumberPrinterUsingExecutorService implements Runnable{

    int ele;

    public NumberPrinterUsingExecutorService(int i){
        this.ele=i;
    }

    @Override
    public void run() {
        System.out.println("Number is " + ele + " Printed by " + Thread.currentThread().getName());
    }
}
