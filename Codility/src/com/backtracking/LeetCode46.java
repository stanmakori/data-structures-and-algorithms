package Codility.src.com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
//    solution 1: mine
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    return permute(nums, permutations,  new ArrayList<Integer>());
}
    private List<List<Integer>> permute(int[] nums,List<List<Integer>> result, ArrayList<Integer> currentPermutation) {
        //check if we found a complete permutaion
        if(currentPermutation.size() == nums.length) {
            result.add(new ArrayList<Integer>(currentPermutation));
        }
        for (int num : nums) {
            if (!currentPermutation.contains(num)) {
                currentPermutation.add(num);
                //explore other possibilities
                permute(nums, result,  currentPermutation);
                //undo the current choice in order to explore the previous choices
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
        return result;
    }
}
