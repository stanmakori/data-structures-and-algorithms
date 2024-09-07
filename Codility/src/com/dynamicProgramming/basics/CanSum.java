package Codility.src.com.dynamicProgramming.basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {
    private Map<Integer, Boolean> memo = new HashMap<>();
    public boolean canSum(int amount, List<Integer> coins) {
        if (amount == 0) {
            return true;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int coin : coins) {
            int remainingAmount = amount - coin;
            if (remainingAmount >= 0 && canSum(remainingAmount, coins)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }
    private boolean canSum1(int amount, List<Integer> coins) {
        if(amount == 0) {
            return true;
        }
        for (int coin : coins) {
            int sumAmount = amount - coin;
            canSum(sumAmount, coins);
            }
        return false;
    }
}
