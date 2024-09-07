package com.oop.Abstractions;

interface TheInterface {
    /*public*/ default void printMessage(){
        System.out.println("Interface void");

    }
    default void hello(){
        System.out.println("hello from TheInterface");
    }
}
interface TheInterface1 {
    default void hello(){
        System.out.println("hello from TheInterface1");
    }
}
abstract class TheAbstract {
    public void printMessage(){
        System.out.println("abstract class void");
    }

}
class Concrete1 implements  TheInterface , TheInterface1{

    /**
     * Whereas the an abstract class's method will be given priority and override the interface method,
     * implementing two interfaces with same method requires implementing one of the default methods,
     * preferably the default mthod from the first listed interface . like in Concrete1, we implement
     * the hello method from TheInterface by default. However, we can remove the call to super and override
     * them all at once.
     *
     */
    @Override
    public void hello() {
        TheInterface.super.hello();
    }
}
public class ComplexInheritance1 extends TheAbstract implements TheInterface {
    public static void main(String[] args){
       new ComplexInheritance1().printMessage();//abstract class void.
        //Reason: abstract class method given priority

    }
}
