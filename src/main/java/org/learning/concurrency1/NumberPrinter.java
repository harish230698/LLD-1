package org.learning.concurrency1;

public class NumberPrinter implements Runnable{

    int ele;

    public NumberPrinter(int i){
        this.ele=i;
    }

    @Override
    public void run() {
        System.out.println("Number is " + ele + " Printed by " + Thread.currentThread().getName());
    }
}
