package com.company;

public class Process {

    private String name;

    private StringBuilder addressSpace;

    public Process(String name, StringBuilder allocatedMemory ){
        this.name = name;
        this.addressSpace = allocatedMemory;
        //        this.addressSpace = new StringBuilder();
    }


    public String getName(){
        return name;
    }


    public void setAddressSpace(StringBuilder memory){
        addressSpace = memory;
    }

    public StringBuilder getAddressSpace(){
        return addressSpace;
    }

}
