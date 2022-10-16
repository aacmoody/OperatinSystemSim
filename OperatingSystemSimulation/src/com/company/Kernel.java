package com.company;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Kernel {


    private static ArrayList<String> kernelProcessLogs;

    private static boolean SHUTDOWN = false;
    private static InputOutput io;
    private static Processor processor;
    private static TaskScheduler taskScheduler;
    private static ExecutorService executorService;


    public static void main(String[] args){
        System.out.println("Kernel Running");

        kernelProcessLogs = new ArrayList<>();

        io = new InputOutput();
        processor = new Processor();


        taskScheduler = new TaskScheduler(processor);
        startingProcesses(); //Start 3 initial process for the Kernel to run

        executorService = Executors.newCachedThreadPool();
        executorService.execute(io);
        executorService.execute(processor);

        while (!SHUTDOWN){
            try {
                Thread.sleep(1000);
                taskScheduler.switchProcess();

            }catch (Exception ignore){
            }
        }
        System.out.println("Shutting down operating system simulation");
        System.out.println("Printing process logs");

        executorService.shutdown();
    }

    public static void SHUTDOWN(){
        System.exit(0);
    }

    public static void startingProcesses(){
        Process p1 = new Process("Process1");
        Process p2 = new Process("Process2");
        Process p3 = new Process("Process3");
        taskScheduler.addProcess(p1);
        taskScheduler.addProcess(p2);
        taskScheduler.addProcess(p3);

    }

    public static void userCreateProcess(String name){
        taskScheduler.addProcess(new Process(name));

    }

    public static void addLog(String line){
        kernelProcessLogs.add(line);
    }

    public static void printLog(){
        System.out.println(kernelProcessLogs.size());
        for(String current: kernelProcessLogs){
            System.out.println(current);
        }
    }

    public static void printProcesses(){
        taskScheduler.printProcesses();
    }

}
