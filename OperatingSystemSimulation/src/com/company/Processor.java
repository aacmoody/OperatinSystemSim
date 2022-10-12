package com.company;

public class Processor implements Runnable {

    private boolean SHUTDOWN = false;

    public Process currentProcess;

    //public MemoryBlock currentMemory;


    //This will take a new process and return the old process
    public Process switchProcess(Process newProcess){

        Process oldProcess = currentProcess;
        currentProcess = newProcess;

        Kernel.addLog("Pausing " + oldProcess.getName() + " at time" + System.currentTimeMillis() +
                "\nStarting " + newProcess.getName() + " at time " + System.currentTimeMillis() + "\n");

        //System.out.println("Pausing " + oldProcess.getName() + " at time" + System.currentTimeMillis());
        //System.out.println("Starting " + newProcess.getName() + " at time " + System.currentTimeMillis());

        return oldProcess;
    }

    @Override
    public void run() {
        System.out.println("Processor is ready");
        while(!SHUTDOWN){
                 //System.out.println("Running process: " + currentProcess.getName());


            //Add random character to memory block to represent new work?
            //Thread.Sleep(10);

        }
    }


    public void setSHUTDOWN(){
        SHUTDOWN = true;
    }


}
