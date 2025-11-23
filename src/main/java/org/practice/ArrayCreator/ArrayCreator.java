package org.practice.ArrayCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {

    int num;

    public ArrayCreator(int num){
        this.num=num;
    }

    @Override
    public List<Integer> call() throws Exception {

        List<Integer> ans = new ArrayList<>();


        for(int i=1;i<=num;i++){
            if(i==50 || i==99){
                System.out.println("DEBUG");
            }
            ans.add(i);
        }
        return ans;
    }

    public List<Integer> addList(List<Integer> arr,int i){

        arr.add(i);

        return arr;
    }
}
