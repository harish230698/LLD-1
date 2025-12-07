package org.learning.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EasyStreamsProblems {

    public static void main(String[] args) {

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

//        streamIterated.forEach(System.out::println);

        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));

        stream.forEach(System.out::print);

        //Task-1 - count no of strings having length greater than 6
        List<String> list = Arrays.asList("java","scaler","stream","streams","programming","data structures");

        //Task-2 - add 10% to the below double list
        List<Double> listdouble = Arrays.asList(100.0,50.0,200.5,500.67);


        //Task-3 -Calculate the sum of all the numbers greater than 10
        List<Integer> intList = Arrays.asList(5,30,25,10,7,13);




    }
}
