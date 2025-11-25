package org.learning.synchronization.AdderSubtractorSyncMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Count count = new Count();
//        Lock lock = new ReentrantLock();

        Adder add = new Adder(count);

        Subtractor sub = new Subtractor(count);

        Thread t1 = new Thread(add);

        Thread t2 = new Thread(sub);

        t1.start();
        t2.start();

        t1.join();//wait for the thread to complete it's execution
        t2.join();

        System.out.println(count.getValue());

    }
}
