package Codility.src.com.basics;

public class ClassBehavior {
    static int x;
    int y;

    private static int staticMethod(){ //class method
        System.out.println(x);
        ClassBehavior cb = new ClassBehavior();
        System.out.println(cb.y);
        return 30;
    }
    private int intMethod() {//instance method
        return 45;
    }
    private int intMethod1() {//instance method
        int testVar = intMethod();
        System.out.println(x);
        System.out.println(y);
        return testVar;
    }
    public static void main( String[] p) {
       int staticInt = staticMethod();
        ClassBehavior cb = new ClassBehavior();
        cb.intMethod();
    }
}
