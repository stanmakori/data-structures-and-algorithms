import java.util.Arrays;
import java.util.Collections.*;
import java.util.stream.Collectors;
public class Pythons {

    int realSum(int[] nums)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum*10+nums[i];
        }
        return sum;
    }
    public static void main(String[] args)
    {
        System.out.println(new Pythons().realSum(new int[]{1,2,3}));
        System.out.println(new Pythons().realSum(new int[]{4,9,0,5,1}));

    }
}
