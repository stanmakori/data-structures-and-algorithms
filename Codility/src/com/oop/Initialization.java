package com.oop;

public class Initialization {
    final int x;
    final double y;
    final int z;
    Initialization(int x , double z){
        this.x = x;//mst initialize , otherwise int cant compile
        this.y = x; //it is ok to initialize double with int
//        this.z = z;//you cant initialize an int with a double
        this.z = 0;
    }
    public class Internal{
        public final int x;
//        public Internal(){
////            x =10;withot this , the class cannot compile , because a no-argument constructor
////            provided no guarantee that x will finally be initialized. The idea is that by the time
////            you create an object for the current class , all fields MUST be initialized properly.
////            Now if yoi called Internal in = new Internal(); you shall have bypassed initializing
////            x!!
//
//        }
        public Internal(int x, int y){
            this(x);

        }
        public Internal(int x){
            this.x =x;
        }

    }
}
