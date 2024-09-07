package com.oop.Enums;

class MasterException extends Exception {

    public MasterException() {
    }
}
class SlaveException extends MasterException {

    public SlaveException() {
    }
}

public class ExceptionHandling {
    public static void main(String... args) throws SlaveException {
        try {
            throw new MasterException();
        }
        catch( Exception e) {
           throw new SlaveException();
        }
    }
}
