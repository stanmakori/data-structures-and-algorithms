package Codility.src.com.string.basics;

public class SplitOperations {
    static void delimitParts(){
        String input = "2024-06-13T07:35:02Z:log 1 msg 1";
        String[] parts = input.split(":", 2);
        String dateTime = parts[0];
        System.out.println(dateTime);

    }
    static void delimitByKey(){
        String input = "2024-06-13T07:35:02Z : log 1 msg 1";
        String[] parts = input.split(" : ", 2);
        String dateTime = parts[0];
        System.out.println(dateTime);
    }
    static void limitReturnedArrays(){
        String input = "2024-06-13T07:35:02Z:log 1 msg 1";
        String[] parts = input.split(":", 2);
        for (String value : parts) {
            System.out.println(value);
        }
    }
    public static void main(String...args) {
//        System.out.println("====delimit by parts====");
//        delimitParts();
//        System.out.println("====delimit by key====");
//        delimitByKey();
        limitReturnedArrays();
    }
}
