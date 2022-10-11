package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    //Start our operating system

    public static void main(String[] args){

        Kernel kernel = new Kernel();
        ExecutorService executorService = Executors.newCachedThreadPool();



     //   executorService.execute(kernel);
        executorService.shutdown();
    }
}
