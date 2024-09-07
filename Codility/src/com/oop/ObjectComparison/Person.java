package com.oop.ObjectComparison;

import java.util.Arrays;
import java.util.Comparator;

public class Person implements Comparator<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public int compareTo(Person person) {
        return person.name.compareTo(this.name);
    }

    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Person o1, Person o2) {
        return  o2.name.compareTo( o1.name);
    }

    public static void main(String[] args) {
//        basicSort();
        Person[] people = {new Person("Joe"), new Person("Jane"), new Person("John")};
        Arrays.sort(people);
        for (Person person : people) {
            System.out.println(person.name);
        }
    }
}