package com.oop;

public class MethodConcflicts {
    MethodConcflicts(){

    }
    String MethodConcflicts(){
        return "Makori";
    }
    public static void main(String...args) {
        System.out.println(new MethodConcflicts().MethodConcflicts());

    }
}
