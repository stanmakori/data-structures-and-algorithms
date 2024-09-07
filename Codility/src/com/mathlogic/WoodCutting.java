package Codility.src.com.mathlogic;

public class WoodCutting {
        // Function to calculate the greatest common divisor (GCD) using Euclidean algorithm
    //https://leetcode.com/discuss/interview-question/1774669/largest-possible-square-for-cut-sticks
        private int solution(int A, int B) { //1 <= (A, B)<= 1 Billion
            if (A + B < 4) {
                return 0;
            }

            int high = (A + B) / 4;
            int low = 1;

            while (low + 1 < high) {
                int mid = low + (high - low) / 2;

                if (A / mid + B / mid >= 4) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            if (A / high + B / high >= 4) {
                return high;
            } else {
                return low;
            }
        }
    public int solution1(int A, int B) {
        int totalSticks = A + B;
        int maxLenghthTogether = totalSticks / 4;
        while(maxLenghthTogether > 0) {
            int maxLenghthA = A / maxLenghthTogether;
            int maxLenghthB = B / maxLenghthTogether;
            if(maxLenghthA + maxLenghthB >= 4) {
                return maxLenghthTogether;
            }
            maxLenghthTogether--;
        }
        return 0;
    }

        public static void main(String[] args) {
            WoodCutting sol = new WoodCutting();
            System.out.println(sol.solution(10, 21));  // Output: 7
            System.out.println(sol.solution(13, 11));  // Output: 5
            System.out.println(sol.solution(2, 1));    // Output: 0
            System.out.println(sol.solution(1, 8));    // Output: 2
            System.out.println(sol.solution(48, 18));    // 16
            System.out.println(sol.solution(4, 8));    // 2 - wrong
            System.out.println("=====Solution 2=======");
            System.out.println(sol.solution1(10, 21));  // Output: 7
            System.out.println(sol.solution1(13, 11));  // Output: 5
            System.out.println(sol.solution1(2, 1));    // Output: 0
            System.out.println(sol.solution1(1, 8));    // Output: 2
            System.out.println(sol.solution1(48, 18));    // 16
            System.out.println(sol.solution1(4, 8));    // 2 -
        }
}
