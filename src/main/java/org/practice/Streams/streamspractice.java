package org.practice.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamspractice {

    public static void main(String[] args) {

        /*
    1️⃣ Problem 1 — Filter even numbers

        Task:
        From the given list of integers, return all even numbers.

        Required Ops: filter, collect

        Input Stream:
        */

        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        List<Integer> evenList = numbers.stream().filter(x -> x % 2 == 0).toList();

        System.out.println(evenList);

        /*
            2️⃣ Problem 2 — Convert names to uppercase

        Task:
        Convert all names to uppercase.

                Required Ops: map, collect

        Input Stream:
         */

        List<String> names = Arrays.asList("harish", "alex", "manoj", "ram");

        List<String> uppernames = names.stream().map(String::toUpperCase).toList();

        System.out.println(uppernames);

        /*
            3️⃣ Problem 3 — Remove duplicates

            Task:
            Return only unique elements.

            Input Stream:
         */

        List<Integer> values = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> uniqueValues = values.stream().distinct().toList();

        System.out.println(uniqueValues);

        /*
            4️⃣ Problem 4 — Sort strings alphabetically

        Task:
        Sort values in ascending order.

        Input Stream:
         */


        List<String> fruits = Arrays.asList("Banana", "Apple", "Grapes", "Mango");

        List<String> sortedFruits = fruits.stream().sorted().toList();

        System.out.println(sortedFruits);

        /*
            5️⃣ Problem 5 — Count numbers greater than 50

        Task:
        Count how many numbers are greater than 50.

        Input Stream:
         */


        List<Integer> nums = Arrays.asList(10, 60, 55, 30, 100);

        long numsCount = nums.stream().filter(x->x>50).count();

        System.out.println(numsCount);

        /*
             6️⃣ Problem 6 — Limit & print first 3 elements

        Task:
        Print the first 3 names from the list.

        Input Stream:
         */


        List<String> names2 = Arrays.asList("A", "B", "C", "D", "E");

        names2.stream().limit(3).forEach(x-> System.out.print(x + " "));

        System.out.println();

        /*
            7️⃣ Problem 7 — Skip first 2 numbers

        Task:
        Skip first 2 numbers, print the rest.

        Input Stream:
         */

        List<Integer> data = Arrays.asList(100, 200, 300, 400, 500);

        data.stream().skip(2).forEach(x->System.out.print(x + " "));

        System.out.println();

        /*
            8️⃣ Problem 8 — Check if any number is negative

        Task:
        Return true if any number is negative.

        Input Stream:
         */

        List<Integer> list = Arrays.asList(1, 5, -2, 10, 8);

        boolean res = list.stream().anyMatch(x->x<0);

        System.out.println(res);

        /*
            9️⃣ Problem 9 — Check if all numbers are even

        Task:
        Return true if all numbers are even.

        Input Stream:
         */

        List<Integer> evenCheck = Arrays.asList(2, 4, 6, 8, 10);

        boolean alleven = evenCheck.stream().allMatch(x->x%2==0);

        System.out.println(alleven);

        /*
            🔟 Problem 10 — Multiply each number by 10 & collect

        Task:
        Multiply each number by 10 and return new list.

        Input Stream:
         */

        List<Integer> base = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> multipliedres = base.stream().map(x->x*10).collect(Collectors.toList());

        System.out.println(multipliedres);
    }
}
