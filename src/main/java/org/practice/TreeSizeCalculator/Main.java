package org.practice.TreeSizeCalculator;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Node root = new Node(10);

        // Add children
        root.left = new Node(5);
        root.right = new Node(15);

        // Add grandchildren
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        ExecutorService executorService = Executors.newCachedThreadPool();

        TreeSizeCalculator node = new TreeSizeCalculator(root,executorService);

        Future<Integer> res = executorService.submit(node);

        System.out.println(res.get());

    }
}
