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
    private static MemoryManager memoryManager;

    public static void main(String[] args){
        System.out.println("Kernel Running");

        kernelProcessLogs = new ArrayList<>();

        io = new InputOutput();
        processor = new Processor();
        memoryManager = new MemoryManager();

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
        Process p1 = new Process("Process1", memoryManager.getBlock());
        Process p2 = new Process("Process2", memoryManager.getBlock());
        Process p3 = new Process("Process3", memoryManager.getBlock());
        taskScheduler.addProcess(p1);
        taskScheduler.addProcess(p2);
        taskScheduler.addProcess(p3);

    }

    public static void userCreateProcess(String name){
        taskScheduler.addProcess(new Process(name, memoryManager.getBlock()));

    }

    public static void showData(){
        taskScheduler.showData();
    }

    public static void addLog(String line){
        kernelProcessLogs.add(line);
    }

    public static void printLog(){
        System.out.println("\n" + kernelProcessLogs.size());
        for(String current: kernelProcessLogs){
            System.out.println(current);
        }
    }

    public static void printProcesses(){
        taskScheduler.printProcesses();
    }

    public static void saveData(String fileName){
        StorageManager.saveData(fileName, taskScheduler.getData());
    }

    public static void readData(String fileName){
        StorageManager.readData(fileName);
    }
}
