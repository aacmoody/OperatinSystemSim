package com.company;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Kernel {

    private static boolean SHUTDOWN = false;
    private static InputOutput io;

    ExecutorService executorService;


    public static void main(String[] args){
        System.out.println("Kernel Running");

        io = new InputOutput();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(io);


        while (!SHUTDOWN){
            try {
                Thread.sleep(100);

            }catch (Exception e){

            }

        }

    }

    public static void SHUTDOWN(){
        SHUTDOWN=true;
    }




}
