package com.activity.activity;

import static com.activity.util.CommonUtil.stopWatch;

import java.util.concurrent.*;

// Thread Pool Executor Example
class ThreadPoolUsingExecutor {

    //Thread Pool created using ExecutorService
    //We have using Runtime class and using available processors present in the system
    static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args)
    {
        //Stop watch will calculate time taken by our task to get complete
         stopWatch.start();
         //Now accesing our thread pool executor service throught future.
            // this will be our task one
         Future<?> taskOne =  executorService.submit(()-> System.out.println("Task one is completed"));
            //this will be out task two
         Future<?> taskTwo =  executorService.submit(()-> System.out.println("Task two is completed"));

         stopWatch.stop();
         //this will display total time taken by the task
        System.out.println(("Total Time Taken : "+ stopWatch.getTime()));
         //We call shutdown method so that our thread pool get closed.
         executorService.shutdown();

            }
        }

