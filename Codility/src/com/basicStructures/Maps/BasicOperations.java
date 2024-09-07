package com.basicStructures.Maps;

import java.util.HashMap;
import java.util.Map;

public class BasicOperations {
    static void clearKeys(){
        Map<String , String> map = new HashMap<>();
        map.put("A","1");
        map.put("B","2");
        map.put("C","3");
        System.out.println(map);
        map.clear();
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }
    public static void main(String[] args){
        clearKeys();
    }
}
