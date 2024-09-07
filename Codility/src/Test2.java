import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public String[] solution(String S, String[] B) {
        // write your code in Java SE 8
        List<Double> list = Arrays.stream(B).sorted(Comparator.comparingDouble(v->Double.valueOf((String) v)).reversed()).map(Double::parseDouble).collect(Collectors.toList());

        Double S1 = Double.valueOf(S);

        String strings[] = new String[B.length];
        Double total = 0.00;


        for (int i = 0; i< list.size(); i++){
            Double individualValue = list.get(i);
            Double sumTotal = 0.0;
            for(int j = i+1;j < list.size(); j++){
                sumTotal+=list.get(j);
            }
            BigDecimal data = new BigDecimal(S1 * (individualValue / (individualValue + sumTotal)));
            data = data.setScale(2, RoundingMode.FLOOR);
            total+=data.doubleValue();
            strings[i] = String.valueOf(data);
            S1 = S1 - Double.valueOf(strings[i]);

        }
        Double diff = new BigDecimal(Double.valueOf(S) - total).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
        strings[B.length-1] = String.valueOf(Double.valueOf(strings[B.length-1]) + diff);
        return strings;
    }
    public static void main(String[] args)
    {

    }
}
