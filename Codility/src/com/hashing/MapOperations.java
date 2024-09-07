package Codility.src.com.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOperations {
    void hashcoding(){
        String key = "FB";
        int hash = key.hashCode();
        System.out.println(hash);
    }
    void findIndexOfBucket() {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println(list.size());
        int size = list.size();
        String key = "FB";
        int hash = key.hashCode();
        int indexOfBucket = hash & (16 - 1);
        System.out.println("=====The index of bucket is :"+indexOfBucket);
    }
    void mapGetOrDefault(){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(1, frequencyMap.getOrDefault(1, 0)+ 1);
    }
    void mapComputeIfAbseent(){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(1, frequencyMap.getOrDefault(1, 0)+ 1);
        frequencyMap.computeIfAbsent(1, a -> frequencyMap.getOrDefault(1, 0) + 1);
        System.out.println(frequencyMap);//{1=1} beuacse the computeIfAbsent is only executed if there is a miss
    }
    public static void main(String[] args) {
        MapOperations mo = new MapOperations();
        mo.hashcoding();
        mo.findIndexOfBucket();
        int x = 7;
        int y = 3;
        int result = (int) Math.ceil((double) x /(double) y);
        int result1 = (x + y - 1) / y;
//        (double) x / y ensures that the division is performed as a
//        floating-point operation.
        System.out.println("==ceiling of x and y is "+ result);
        System.out.println("==ceiling of x and y is "+ result1);//same as above
        mo.mapComputeIfAbseent();
    }
}
