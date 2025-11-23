package org.learning.MultiThreadedMergerSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortCallable implements Callable<List<Integer>> {

    List<Integer> listToSort;

    ExecutorService executorService;


    public MergeSortCallable(List<Integer> numbers,ExecutorService executorService){
        this.listToSort=numbers;
        this.executorService=executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        //Logic of merge Sort

        int n=listToSort.size();

        if(n<=1)
            return listToSort;

        List<Integer> leftSubList = listToSort.subList(0,n/2);

        List<Integer> rightSubList = listToSort.subList(n/2,n);

//        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSortCallable leftMergeSortCallable = new MergeSortCallable(leftSubList,executorService);
        MergeSortCallable rightMergeSortCallable = new MergeSortCallable(rightSubList,executorService);

        Future<List<Integer>> leftSortedList = executorService.submit(leftMergeSortCallable);
        Future<List<Integer>> rightSortedList = executorService.submit(rightMergeSortCallable);

        //Merge 2 sorted List
        List<Integer> ans = mergeTwoSortedList(leftSortedList.get(),rightSortedList.get());

        return ans;
    }

    public List<Integer> mergeTwoSortedList(List<Integer> leftList,List<Integer> rightList){

        List<Integer> ans = new ArrayList<>();

        int i=0,j=0;

        while (i<leftList.size() && j<rightList.size()){
            if(leftList.get(i)<rightList.get(j)){
                ans.add(leftList.get(i));
                i++;
            }else{
                ans.add(rightList.get(j));
                j++;
            }
        }

        while (i<leftList.size()){
            ans.add(leftList.get(i));
            i++;
        }

        while (j<rightList.size()){
            ans.add(rightList.get(j));
            j++;
        }

        return ans;
    }
}
