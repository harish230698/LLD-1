package org.learning.synchronization.AdderSubtractorSyncMethod;

public class Count {

    private int value;

    public synchronized void addValue(int i){
        value+=i;
    }

    public int getValue(){
        return value;
    }
}
