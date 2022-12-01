package com.activity.activity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ParalllelAndSequential {
    public static void main(String[] args) {

        //This is example of parallel stream.
        List<Integer> listOfParallel = Arrays.asList(1, 2, 3, 4);
        listOfParallel.parallelStream().forEach(number ->
                System.out.println("Parallel Stream"+number + " " + Thread.currentThread().getName())
        );

        //This is example of Sequential Stream
        List<Integer> listOfSequential = Arrays.asList(1, 2, 3, 4);
        listOfSequential.stream().forEach(number ->
                System.out.println("Sequential Stream" +number + " " + Thread.currentThread().getName())
        );

    }
}
