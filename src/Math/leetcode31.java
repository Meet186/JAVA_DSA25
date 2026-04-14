package Math;

import java.util.Arrays;
public class leetcode31 {
    public static void reverseArray(int[] arr, int start) {
        int left = start;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int swap_index_1 = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                swap_index_1 = i - 1;
                break;
            }
        }
        if (swap_index_1 != -1) {
            int swap_index_2 = -1;
            for (int i = n - 1; i > swap_index_1; i--) {
                if (nums[i] > nums[swap_index_1]) {
                    swap_index_2 = i;
                    break;
                }
            }
            swap(nums, swap_index_1, swap_index_2);
        }
        reverseArray(nums, swap_index_1 + 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        nextPermutation(arr);
    }
}