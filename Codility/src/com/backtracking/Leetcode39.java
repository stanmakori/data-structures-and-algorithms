package Codility.src.com.backtracking;
import java.util.ArrayList;
import java.util.List;
public class Leetcode39 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), candidates, target, 0);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remaining, int start) {
            if (remaining < 0) {
                return; // if remaining is less than 0, no point in continuing
            } else if (remaining == 0) {
                result.add(new ArrayList<>(tempList)); // found a combination that sums up to target
            } else {
                for (int i = start; i < candidates.length; i++) {
                    tempList.add(candidates[i]); // choose the candidate
                    backtrack(result, tempList, candidates, remaining - candidates[i], i); // explore further with the chosen candidate
                    tempList.remove(tempList.size() - 1); // backtrack, remove the last chosen candidate
                }
            }
        }
}