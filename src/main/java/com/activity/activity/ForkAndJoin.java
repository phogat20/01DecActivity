package com.activity.activity;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


import static com.activity.util.CommonUtil.delay;
import static com.activity.util.CommonUtil.stopWatch;


public class ForkAndJoin extends RecursiveTask<List<String>> {
    //Fork and join extension of Executor Service
    //Fork and join framework is designed to achieve data parallelism
    //Fork and Join pool support Data Parallelism
    public ForkAndJoin(List<String> inputList) {
        this.inputList = inputList;
    }

    private List<String> inputList;


    public static void main(String[] args) {
        stopWatch.start();
          //This will be our final list
        List<String> finalList = new ArrayList<>();
        //Name of list has been created to fork and then join
        List<String> nameList = List.of("Chetan", "Sumit", "Prabjot", "Dixit");

        //Createing object of ForkJoin pool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkAndJoin forkJoin = new ForkAndJoin(nameList);

        //Invoking in final list
        finalList = forkJoinPool.invoke(forkJoin);

        stopWatch.stop();
        //Printing List
        System.out.println(("Final List : " + finalList));
        System.out.println(("Total Time Taken : " + stopWatch.getTime()));
    }

    //Overrided
    @Override
    protected List<String> compute() {
        if (inputList.size() <= 1) {
            List<String> resultList = new ArrayList<>();
            inputList.forEach(name -> resultList.add(addNameLengthTransform(name)));
            return resultList;
        }
        int midpoint = inputList.size()/2;
        ForkJoinTask<List<String>> leftInputList =  new ForkAndJoin(inputList.subList(0,midpoint)).fork();
        inputList = inputList.subList(midpoint,inputList.size());
        List<String> rightResult =  compute();
        List<String> leftResult =  leftInputList.join();
        leftResult.addAll(rightResult);
        return leftResult;
        }
    public static String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }
    }

