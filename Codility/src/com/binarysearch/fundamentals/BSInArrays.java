package Codility.src.com.binarysearch.fundamentals;

public class BSInArrays {
    int findLastOcurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = - 1;//initially not found
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                lastIndex = mid;
                left++; //explore for other possibilities
            }
            else {
                right = mid - 1;
            }
        }
        return lastIndex;
    }
    public static void main(String[] args) {
        BSInArrays bs = new BSInArrays();
        //scenario 1: same elements: we expect to return last index
        System.out.println(bs.findLastOcurrence(new int[]{1,1,1,1}, 1));//
        //scenario 2: target not found
        System.out.println(bs.findLastOcurrence(new int[]{1,1,1,1}, 4));
    }
}
