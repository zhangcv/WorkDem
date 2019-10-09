package com.juc.demo201904;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class Mythread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*************** come in the method");
        return 1024;
    }
}




/**
 * Creacted by jack on 2019/10/30 13:27
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask(new Mythread());

        new Thread(futureTask,"A").start();
        Integer result = futureTask.get();
        System.out.println(result);
    }
}

