package com.Generics;

import java.util.*;

public class MasterRef {
    public class Parent {
        public List<Number> foo(Set<CharSequence> m) {
            return null;
        }

    }
    //Freedom 1: override parent method with same data types and generic type
    public class Child extends Parent{
        public List<Number> foo(Set<CharSequence> m) {
            return null;
        }
    }
    //Freedom 2: override parent method with sub return types with same generic types
    public class Child1 extends Parent{
        @Override
        public ArrayList<Number> foo(Set<CharSequence> m) {
            return null;
        }
    }
    //Freedom 3: playing with parameter types
    public class Child2 extends Parent{
        //if parameters change, then whatever the return type is just overloading
        public List<Number> foo(HashSet<CharSequence> m) {
            return null;
        }
        public String foo(TreeSet<CharSequence> m) {
            return null;
        }
        @Override
        public ArrayList<Number> foo(Set<CharSequence> m) {
            return null;
        }
    }
}
