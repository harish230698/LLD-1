package org.practice.TreeSizeCalculator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    Node root;

    ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService){
        this.root = root;
        this.executorService=executorService;
    }

    @Override
    public Integer call() throws Exception {

        if(root==null)
            return 0;

//        ExecutorService executorService1 = Executors.newCachedThreadPool();

        TreeSizeCalculator leftTree = new TreeSizeCalculator(root.left,executorService);
        TreeSizeCalculator rightTree = new TreeSizeCalculator(root.right,executorService);

        Future<Integer> leftsize=executorService.submit(leftTree);
        Future<Integer> rightsize = executorService.submit(rightTree);

        int leftTreeSize = leftsize.get();
        int rightTreeSize = rightsize.get();

        return Math.max(leftTreeSize,rightTreeSize)+1;
    }

}