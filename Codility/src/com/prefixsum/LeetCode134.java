package Codility.src.com.prefixsum;

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int start = 0;
        int totalGain = 0;  // Track total gain/loss around the circuit

        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            totalGain += gas[i] - cost[i];  // Accumulate total gain/loss

            if (tank < 0) {
                start = i + 1;  // Shift starting point
                tank = 0;  // Reset tank
            }
        }

        return totalGain >= 0 ? start : -1;  // Check for overall feasibility
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, remainsGas = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            remainsGas += gas[i] - cost[i];

            // If remaining gas becomes negative, update the start station
            if (remainsGas < 0) {
                start = i + 1;
                remainsGas = 0;
            }
        }

        // If the total gas is less than the total cost, it's impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }

}
