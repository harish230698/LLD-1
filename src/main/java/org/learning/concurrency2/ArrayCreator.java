package org.learning.concurrency2;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {

    int n;

    public ArrayCreator(int n){
        this.n=n;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=1;i<=n;i++){
            Thread t1 = new Thread();
            t1.start();
        }

        return ans;
    }


}

