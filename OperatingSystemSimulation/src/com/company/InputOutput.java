package com.company;

import java.util.Scanner;

public class InputOutput implements Runnable {

    private boolean SHUTDOWN = false;

    @Override
    public void run() {



        Scanner scanner = new Scanner(System.in);
        System.out.println("I/O output started");

        while(!SHUTDOWN){


            String input = scanner.nextLine();

            System.out.println(input);

            userInput(input);
        }
    }

    private void userInput(String input){
        if(input.contains("Q")){

            Kernel.SHUTDOWN();
            SHUTDOWN = true;

        }
    }


}
