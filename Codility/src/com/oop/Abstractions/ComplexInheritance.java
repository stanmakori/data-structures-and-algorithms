package com.oop.Abstractions;

interface Fred {
    void doExam();
}
abstract class FredAbs {
    public void doExam(){
    }
    abstract void methodB();
}
public class ComplexInheritance extends FredAbs implements Fred  {
    /**
     *
     */
    @Override
    void methodB() {

    }
}
