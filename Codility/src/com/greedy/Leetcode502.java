package Codility.src.com.greedy;
import java.util.*;
public class Leetcode502 {
class Project {
    int capital;
    int profit;

    public Project(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        // Create projects array
        Project[] projects = new Project[profits.length];
        for (int i = 0; i < profits.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort projects based on capital
        Arrays.sort(projects, (a, b) -> a.capital - b.capital);

        // Create min heap based on profit
        PriorityQueue<Project> minHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        int index = 0;
        for (int i = 0; i < k; i++) {
            // Add available projects to min heap
            while (index < projects.length && projects[index].capital <= W) {
                minHeap.offer(projects[index]);
                index++;
            }

            // If no projects available, break
            if (minHeap.isEmpty()) {
                break;
            }

            // Select the most profitable project and update available capital
            W += minHeap.poll().profit;
        }

        return W;
    }
    public static void main(String[] args) {
        Solution solution = new Leetcode502(). new Solution();
        int k = 2;
        int W = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k, W, profits, capital)); // Output: 4
    }
}


}
