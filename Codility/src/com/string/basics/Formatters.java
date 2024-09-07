package Codility.src.com.string.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formatters {
    static void formatOutPut(){
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.printf("The size of the list is {}",list.size());
    }
    public static void main(String[] args) {
        formatOutPut();
    }
}
