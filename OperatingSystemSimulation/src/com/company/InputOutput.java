package com.company;

import java.util.Locale;
import java.util.Scanner;

public class InputOutput implements Runnable {

    private boolean SHUTDOWN = false;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";


    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("I/O output started");
        String input;
        while(!SHUTDOWN){
            System.out.println(ANSI_GREEN + "Enter command" + ANSI_RESET);
            input = scanner.nextLine();

            if(input.trim().toLowerCase().contains("quit") ){
                Kernel.SHUTDOWN();
            } else {
                userInput(input);
            }
        }
        System.out.println("Closing Input");
    }

    public void setSHUTDOWN(){

        SHUTDOWN=true;
    }

    public void userInput(String userInput){
        userInput = userInput.toLowerCase();
        if(userInput.contains("logs")){
            Kernel.printLog();
        } else if(userInput.contains("start")){
            String processName = userInput.replace("start ", "");
            if(processName.length() > 0) {
                Kernel.userCreateProcess(processName);
                System.out.println("Created new process named: " + processName);
            } else {
                System.out.println("Enter a process to start");
            }
        } else if(userInput.contains("processes")){
            Kernel.printProcesses();
        } else if(userInput.contains("help")){
            printHelp();
        }
    }

    public void printHelp(){
        System.out.println("Commands");
        System.out.println("logs\t\t\t\tto show process logs");
        System.out.println("start newName\t\tto create new process");
        System.out.println("processes\t\t\tto view running process");
    }
}
