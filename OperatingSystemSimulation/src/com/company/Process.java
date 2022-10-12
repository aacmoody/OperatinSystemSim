package com.company;

public class Process {

    private String name;

    private StringBuilder addressSpace;

    public Process(String name ){
        this.name = name;
    }


    public String getName(){
        return name;
    }


    /*
    public boolean checkAddressSpace(){
        //If we have exceeded our address space we need to request more
       return (addressSpace.length() > 1000)?  false:  true;
    }
     */

    public StringBuilder getAddressSpace(){
        return addressSpace;
    }

}
