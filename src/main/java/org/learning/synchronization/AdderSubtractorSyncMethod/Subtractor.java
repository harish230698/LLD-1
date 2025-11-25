package org.learning.synchronization.AdderSubtractorSyncMethod;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{

    private Count count;


    Subtractor(Count count){
        this.count=count;
    }
    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            count.addValue(-i);
        }
    }
}
