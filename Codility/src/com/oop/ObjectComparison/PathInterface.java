package com.oop.ObjectComparison;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInterface {
    //relativise with root
    static void relativeiseWithDifferentRoots(){
        Path base = Paths.get("c:\\data\\documents");//it is always recmmended to use Path.of
        Path next = Path.of("d:\\stanley\\makori");
        System.out.println(base.relativize(next));
    }
    static void relativeiseWithSameRoots(){
        Path base = Paths.get("c:\\data\\documents");//it is always recmmended to use Path.of
        Path next = Path.of("c:\\stanley\\makori");
        System.out.println(base.relativize(next));
    }
    public static void main(String[] args) {
//        relativeiseWithDifferentRoots();//IllegalArgumentException
        relativeiseWithSameRoots();
    }
}
