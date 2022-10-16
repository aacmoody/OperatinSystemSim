package com.company;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {

    //We can add constraints to this in order to limit the size
    List<StringBuilder> allMemory = new ArrayList<>();

    public StringBuilder getBlock(){
        StringBuilder block = new StringBuilder();
        allMemory.add(block);

        return block;
    }

}
