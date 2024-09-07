package Codility.src.com.twopointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        //if there is a zero, we skip the right pointer.
        //if we find a non zero, we swap the left and right pointyer values.
        //left pointer moves step by step.
        while (right < nums.length) {
            if (nums[left] != 0) {
                left++;
            }
            else if ( nums[right] != 0 && nums[left] == 0) {
                //swap
                swap(nums, left, right) ;
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int [] nums = {0,1,0,3,12};
        mz.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
