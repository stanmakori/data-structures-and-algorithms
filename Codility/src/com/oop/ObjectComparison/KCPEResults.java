package com.oop.ObjectComparison;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.Comparable;

//class Candidates implements Comparator<Candidates> {
  class Candidates implements Comparable<Candidates> {
    private String name;
    private int marks;

    public Candidates(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
//    @Override
//    public int compare(Candidates o1, Candidates o2) {
//        //return o2.getMarks()-o1.getMarks();
//        //if we wer to compare with names, then e use String's compareTo method
//        return o2.getName().compareTo(o1.getName());
//    }
    public int compareTo(Candidates c) {
        //return o2.getMarks()-o1.getMarks();
        //if we wer to compare with names, then e use String's compareTo method
        return c.getName().compareTo(this.getName());
    }

}
public class KCPEResults {
    public static void main(String[] args) {
        Candidates[] candidates = {new Candidates("Joe",397), new Candidates("Jane",370),
                new Candidates("John",385)};
        //we had to use Comparable because the arrays.sort interface uses comparable
        Arrays.sort(candidates);
        for(Candidates candidate : candidates) {
            System.out.println(candidate.getName());
        }

        }
    }

