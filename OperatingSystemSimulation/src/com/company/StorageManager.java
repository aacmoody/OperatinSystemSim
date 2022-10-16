package com.company;

import java.io.*;
import java.nio.Buffer;

public class StorageManager {

    public static void saveData(String name, String data){
        try {
            String location = "./src/com/company/storage/";
            String longLocation = location + name + ".txt";
            BufferedWriter br = new BufferedWriter(new FileWriter(longLocation));

            br.write(data);
            br.close();

            System.out.println("Data saved to: " + longLocation);

        } catch (IOException ignore){
            System.out.println("Unable to save data");
        }
    }

    public static void readData(String name){
        try{
            String location = "./src/com/company/storage/";
            String longLocation = location + name;
            BufferedReader br = new BufferedReader(new FileReader(longLocation));

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }

            br.close();
        } catch (IOException e){
            System.out.println("Unable to read from file");
        }

    }

}
