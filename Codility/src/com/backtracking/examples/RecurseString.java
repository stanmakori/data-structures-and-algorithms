package Codility.src.com.backtracking.examples;

public class RecurseString {
    StringBuilder sb = new StringBuilder();
    void recurseString(String text) {
        if(sb.length() == text.length()) { //check if we have found a complete permutation
            System.out.println(sb.toString());
        }
        for (char c : text.toCharArray()) {
            String str = ""+c;
            if (!sb.toString().contains(str)){
                sb.append(str);
                recurseString(text);
                sb.deleteCharAt(sb.length() - 1);//backtrack
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("===example 1==========");
        new RecurseString().recurseString("abc");
        System.out.println("===example 2==========");
        new RecurseString().recurseString("boat");
    }
}
