package Codility.src.com.string;

public class SpringOperations {
    void removeSpaces(){
        String name = "  ______makori";
        String s = name.trim();
        System.out.println(s);
    }
    public static void main(String[] args) {
        SpringOperations so = new SpringOperations();
        so.removeSpaces();
    }
}

