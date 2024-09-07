package com.oop.Enums;
import java.lang.Enum;
enum Colors {
    RED("Red"), BLUE("Blue"), GREEN("Green");
    private String name;
    Colors(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        //return this.name.toString();
        //return String.valueOf(Colors.values()[1]);
        return this.name;
    }
}
public class EnumsDiscuss {
    public static void main(String... args){
        System.out.println(Colors.BLUE);
        //System.out.println(Colors.values()[1]);
    }
}
