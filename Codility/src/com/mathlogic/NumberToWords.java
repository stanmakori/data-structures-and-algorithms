package Codility.src.com.mathlogic;
import java.util.Scanner;

public class NumberToWords {

    private static final String[] LESS_THAN_TWENTY = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] THOUSANDS = {"", "thousand", "million", "billion", "trillion"};

    public static String numberToWords(long num) {
        if (num == 0) return "zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper((int) (num % 1000)) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) return "zero";
        else if (num < 20) return LESS_THAN_TWENTY[num] + " ";
        else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else return LESS_THAN_TWENTY[num / 100] + " hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = scanner.nextLong();
        scanner.close();

        String result = numberToWords(num);
        System.out.println(result);
    }
}
