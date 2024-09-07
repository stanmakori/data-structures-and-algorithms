package Codility.src.com.mathlogic;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class BigDecimalClass {
    static void basicMath(){
        BigDecimal a = new BigDecimal("10.5");
        BigDecimal b = new BigDecimal("3.2");
        System.out.println("Addition: " + a.add(b));
        System.out.println("Subtraction: " + a.subtract(b));
        System.out.println("Multiplication: " + a.multiply(b));
        System.out.println("Division: " + a.divide(b, 5, BigDecimal.ROUND_HALF_UP));
    }
    static void basicMath1(){
        BigDecimal a = new BigDecimal("10.5s");//error:s nether decimal nor number
        BigDecimal b = new BigDecimal("3.2");
        System.out.println("Addition: " + a.add(b));
        System.out.println("Subtraction: " + a.subtract(b));
        System.out.println("Multiplication: " + a.multiply(b));
        System.out.println("Division: " + a.divide(b, 5, BigDecimal.ROUND_HALF_UP));
    }
    static boolean doubleComparison(double d, double e) {
        return d == e;
    }
    static void roundingBigDecimals(){
        BigDecimal number = new BigDecimal("1.25");
        System.out.println("ROUND_UP: " + number.setScale(1, RoundingMode.UP));
        System.out.println("ROUND_DOWN: " + number.setScale(1, RoundingMode.DOWN));
        System.out.println("ROUND_CEILING: " + number.setScale(1, RoundingMode.CEILING));
        System.out.println("ROUND_FLOOR: " + number.setScale(1, RoundingMode.FLOOR));
        System.out.println("ROUND_HALF_UP: " + number.setScale(1, RoundingMode.HALF_UP));
        System.out.println("ROUND_HALF_DOWN: " + number.setScale(1, RoundingMode.HALF_DOWN));
    }
    static void precisionAndScale(){
        BigDecimal a = new BigDecimal("123.45600");
        BigDecimal b = new BigDecimal("0.1234560");
        System.out.println("a: precision=" + a.precision() + ", scale=" + a.scale());
        System.out.println("b: precision=" + b.precision() + ", scale=" + b.scale());
        BigDecimal c = a.add(b);
        System.out.println("c (a + b): " + c);
        System.out.println("c: precision=" + c.precision() + ", scale=" + c.scale());
        BigDecimal d = c.stripTrailingZeros();
        System.out.println("d (c stripped): " + d);
        System.out.println("d: precision=" + d.precision() + ", scale=" + d.scale());
    }
    static void financialPrecision() {
        BigDecimal price = new BigDecimal("19.99");
        BigDecimal taxRate = new BigDecimal("0.08");
        int quantity = 3;
        BigDecimal subtotal = price.multiply(BigDecimal.valueOf(quantity));
        BigDecimal tax = subtotal.multiply(taxRate);
        BigDecimal total = subtotal.add(tax);

        System.out.println("Subtotal: $" + subtotal.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Tax: $" + tax.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total: $" + total.setScale(2, RoundingMode.HALF_UP));
    }
    public static void main(String[] args) {
        basicMath();
        double d = 1.00;
        double e = 1.000;
        System.out.println("=== double precision====");
        System.out.println(doubleComparison(d, e));
        System.out.println("=== decimal precision====");
        BigDecimal a = new BigDecimal("1.00");
        BigDecimal b = new BigDecimal("1.000");
        System.out.println(a.equals(b));//false
        System.out.println(a == b);//false

    }
}
