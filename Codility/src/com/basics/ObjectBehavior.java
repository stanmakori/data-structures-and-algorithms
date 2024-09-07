package Codility.src.com.basics;
public class ObjectBehavior {
    public static void main(String[] args) {
        MutableLong testValue = new MutableLong(20L);
        changeValue(testValue);
        System.out.println(testValue.getValue()); // Prints 35
    }

    private static void changeValue(MutableLong testValue) {
        testValue.setValue(35L); // Modifies the state of the object
    }
}

class MutableLong {
    private Long value;

    public MutableLong(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
