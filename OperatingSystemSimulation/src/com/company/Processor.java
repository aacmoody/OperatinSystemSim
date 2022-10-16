package com.company;

import java.util.Random;

public class Processor implements Runnable {

    private boolean SHUTDOWN = false;

    public Process currentProcess;

    public StringBuilder currentMemory = new StringBuilder();

    public StringBuilder interProcStorage = new StringBuilder();

    public Process switchProcess(Process newProcess){

        //Context switching
        Process oldProcess = currentProcess;
        currentProcess = newProcess;

        oldProcess.setAddressSpace(currentMemory);
        currentMemory = newProcess.getAddressSpace();

        Kernel.addLog("Pausing " + oldProcess.getName() + " at time" + System.currentTimeMillis() +
                "\nStarting " + newProcess.getName() + " at time " + System.currentTimeMillis() + "\n");

        return oldProcess;
    }

    @Override
    public void run() {
        Random r = new Random();

        System.out.println("Processor is ready");
        while(!this.SHUTDOWN){

            char work = (char) (r.nextInt(26)+ 65);
            currentMemory.append(work);

            try{
                Thread.sleep(10);
            } catch (InterruptedException ignore){

            }

        }
        System.out.println("Stopping Processor");
    }

    public void setSHUTDOWN(){
        this.SHUTDOWN = true;
    }


    //To Be used for interprocess communication
    public void saveDataTInterprocessStorage(String data){
        interProcStorage.append(data);
    }

    public StringBuilder getDataInterprocessStorage(){
        return interProcStorage;
    }
}
