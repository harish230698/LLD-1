package org.practice.ArrayCreator;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> list = executorService.submit(new ArrayCreator(n));

        System.out.println(list.get());
    }
}
