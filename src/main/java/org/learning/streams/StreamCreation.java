package org.learning.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {

    public static void main(String[] args) {

        /*
            Summary Table
       Data Type	           Stream Creation
        int	                IntStream.of()
        Integer	            Stream.of()
        String	            Stream.of(), chars()
        List	            list.stream()
        Set	                set.stream()
        int[]	            Arrays.stream()
        String[]	        Stream.of()
        Map	                map.entrySet().stream()
        Range	            IntStream.range()
        Random	            Random.ints()
         */

        //INT

        IntStream intStream = IntStream.of(10);

        intStream.forEach(x-> System.out.println(x));

        intStream = IntStream.range(1,10);

        intStream.forEach(x-> System.out.print(x + " "));

        //Integer

        Stream<Integer> integerstream = Stream.of(10);

        System.out.println();

        integerstream.forEach(x-> System.out.println(x));

        integerstream = Stream.iterate(1,n->n+1).limit(10);

        integerstream.forEach(x-> System.out.print(x + " "));

        //String

        Stream<String> strstream = Stream.of("Hello");

        "Hello".chars().mapToObj(c->(char)c).forEach(System.out::print);

        System.out.println();

        //Random

        List<Integer> randomint = new Random().ints(10,1,20).limit(10).distinct().boxed().toList();

        randomint.stream().forEach(x->System.out.print(x + " "));

        System.out.println();

        //Convertions :

        //int[] -> List<Integer>

        int[] arr = {1, 2, 3, 4};

        List<Integer> list = Arrays.stream(arr)   // IntStream
                .boxed()                           // int → Integer
                .toList();

        System.out.println(list);

        //List<Integer> -> int[]

        List<Integer> list1 = List.of(1, 2, 3, 4);

        int[] arr1 = list1.stream()
                .mapToInt(Integer::intValue)   // Integer → int
                .toArray();

        System.out.println(Arrays.toString(arr1));

        //List<String> -> String[]

        List<String> strlist = List.of("A", "B", "C");

        String[] strarr = strlist.stream()
                .toArray(String[]::new);

        System.out.println(Arrays.toString(strarr));
    }
}
