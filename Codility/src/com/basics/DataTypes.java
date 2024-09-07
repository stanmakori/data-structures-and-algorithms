package Codility.src.com.basics;

public class DataTypes {
    public static void main(String[] args) {
        int a = 215;
        byte b = 0x5F;
        double c = 20.36;
        float d = 12.02f;
        long e = 2 ^ 32;

        float  res1 = a + b + 5;
        double  res2 = c - e + d - a;
        long res3 = (long) ((long)a + b + d + e);
        double  res4 = e - 2 * a + b;
        long l2 = a;
        Long longs = null;
        Long lon2 =l2;


        double resSum = res1 + res2 + res3 + res4;
        System.out.println(resSum);
        long los = (long) Math.pow(2, 32);
        int ints = 2 ^ 32;
        long longs1 = 2 ^ 32;
        System.out.println(los);
    }
}
