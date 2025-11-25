package org.practice.Synchronization;

public class Counter {

    private int count;

    Counter(int count){
        this.count=count;
    }

    public synchronized void incValue(int offset){
        count+=offset;
    }

    public synchronized void decValue(int offset){
        count-=offset;
    }

    public synchronized int getValue(){
        return count;
    }
}
