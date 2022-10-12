package com.company;

import java.util.ArrayList;

public class ProcessManager {

    private Processor systemProcessor;

    ArrayList<Process> processes;
    private int activeProcess = 0;

    public ProcessManager(Processor systemProcessor){
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
        System.out.println("Number of Processes running: " + activeProcess);
        for(Process current: processes){
            System.out.println(current.getName());
        }
    }


}
