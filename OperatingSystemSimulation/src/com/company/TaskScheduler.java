package com.company;

import java.util.ArrayList;

public class TaskScheduler {

    private Processor systemProcessor;

    ArrayList<Process> processes;
    private int activeProcess = 0;

    public TaskScheduler(Processor systemProcessor){
        this.systemProcessor = systemProcessor;
        processes = new ArrayList<>();
    }


    public void addProcess(Process process){
        processes.add(process);
    }

    public Process getNextProcess(){
        Process temp = processes.get(activeProcess);
        if((activeProcess + 1) == processes.size()){
            activeProcess = 0;
        } else {
            activeProcess++;
        }
        return temp;
    }

    public void switchProcess(){

        Process returnedProcess = systemProcessor.switchProcess(getNextProcess());
        //returnedProcess.getData assign this to existing process in list
    }

    public void printProcesses(){
        System.out.println("Number of Processes running: " + processes.size());
        for(Process current: processes){
            System.out.println(current.getName());
        }
    }

    public void showData(){
        for(Process current: processes){

            System.out.println(current.getName());
            try {
                System.out.println(current.getAddressSpace().toString());
            } catch (NullPointerException ignore){
                System.out.println("Unable to get data");
            }
        }
    }

    public String getData(){
        StringBuilder data = new StringBuilder();
        for(Process current: processes){
            data.append(current.getName() + "\n");
            data.append(current.getAddressSpace().toString() + "\n");
        }
        return data.toString();
    }


}
