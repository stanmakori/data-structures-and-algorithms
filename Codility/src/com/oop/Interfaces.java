package com.oop;

interface I1 {
    void sound();
    public default void sounds(){
        System.out.println("Sound from I1");
    }
}
interface I2 {
    void sound();
    public default void sounds(){
        System.out.println("Sound from I2");
    }
}
public class Interfaces implements  I1, I2{
    @Override
    public void sound() {
        System.out.println("I did override both unrelated methods at once");
    }

    /**
     * This demonstrates that implementing sound method sorts both I1 & I2.
     * Similarly , since the default method sounds() is in both interfaces,
     * you must implement one to support both
     */
    @Override
    public void sounds() {
        I1.super.sounds();
    }

    public static void main(String[] args) {
        I1 i1 = new Interfaces();
        I2 i2 = new Interfaces();
        i1.sound();
        i2.sound();
    }
}
interface I3 {
//    void name();
}
interface I4 extends I3 {
//    void name();

}
//Inheriting two or more interfaces that extends each other does not amount to cyclic inheritance.
class IClass implements I3 , I4 {

}
//class Person extends Person { cyclic inheritance is when a class inherits itself. Not supported.
//
//}
