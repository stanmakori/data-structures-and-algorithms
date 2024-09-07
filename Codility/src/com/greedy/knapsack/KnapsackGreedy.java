package Codility.src.com.greedy.knapsack;

import java.util.Arrays;

public class KnapsackGreedy {
    static class Item implements Comparable<Item> {
        int weight;
        int value;
        double valuePerWeight; // Value per unit weight

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = (double) value / weight; // Calculate value per unit weight
        }

        // Sort items in descending order of value per unit weight
        public int compareTo(Item other) {
            return Double.compare(other.valuePerWeight, this.valuePerWeight);
        }
    }

    public static double knapsackGreedy(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        // Create items array
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        // Sort items based on value per unit weight in descending order
        Arrays.sort(items);

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        // Fill the knapsack greedily
        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take a fraction of the item if it doesn't fit completely
                totalValue += (item.valuePerWeight * remainingCapacity);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = knapsackGreedy(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
