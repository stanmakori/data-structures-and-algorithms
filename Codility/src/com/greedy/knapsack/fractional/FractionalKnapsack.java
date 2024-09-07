package Codility.src.com.greedy.knapsack.fractional;

import java.util.*;
        /*
        Fractional Knapsack Problem:
        In the fractional knapsack problem, we are allowed to take fractions of items.
        The goal is to maximize the total value of the items taken while not exceeding the capacity
        of the knapsack.

        Here's the basic approach for the fractional knapsack problem:

        Calculate the ratio of value to weight for each item.
        Sort the items based on this ratio in non-increasing order.
        Take items with the highest ratio until the knapsack is full.
         */
class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double totalValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                totalValue += item.value;
                currentWeight += item.weight;
            } else {
                int remainingCapacity = capacity - currentWeight;
                totalValue += (double)item.value / item.weight * remainingCapacity;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50;
        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
