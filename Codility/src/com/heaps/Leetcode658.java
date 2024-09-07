package Codility.src.com.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode658 {
    //option 1: Binary search
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Binary search to find the closest element to x
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Initialize two pointers to find the k closest elements
        int l = left - 1;
        int r = left;

        // Use two-pointer approach to find the k closest elements
        while (k > 0) {
            if (l < 0) {
                r++;
            } else if (r >= n) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
            k--;
        }

        // Collect the k closest elements
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }

        return result;
    }
    //option 2: Priority Queue
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        // Intrinsic sort based on the difference, if the absolute diff is same, it will pick the smallest element.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(x-a) != Math.abs(x-b) ?
                Math.abs(x-b) - Math.abs(x-a): b-a);
        for(int i: arr){ // inject array elements into PQ.
            pq.offer(i);
            if(pq.size() > k) pq.poll(); // Remove one when size is more than k.
        }
        List<Integer> out = new ArrayList<>(pq);
        Collections.sort(out); // the list as it will be in reverseorder.
        return out;
    }
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1 - x) == Math.abs(n2 - x)) {
                return n2 - n1;
            }

            return Math.abs(n2 - x) - Math.abs(n1 - x);
        });

        for (int num: arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(heap.remove());
        }

        Collections.sort(ans);
        return ans;
    }
         public List<Integer> findClosestElements3(int[] arr, int k, int x) {
         PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
             if (Math.abs(n1 - x) == Math.abs(n2 - x)) {
                 return n2 - n1;
             }

             return Math.abs(n2 - x) - Math.abs(n1 - x);
         });

         for (int num: arr) {
             heap.add(num);
             if (heap.size() > k) {
                 heap.remove();
             }
         }

         List<Integer> ans = new ArrayList<>();
         for (int i = 0; i < k; i++) {
             ans.add(heap.remove());
         }

         Collections.sort(ans);
         return ans;
     }
//     option 4: using binary search
    public List<Integer> findClosestElements4(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        // Use binary search to find the closest element to x
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        // Collect the k closest elements
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
