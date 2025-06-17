package Sorting;
import java.util.*;
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class leetcode_448 {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            int correct_index = nums[i]-1;
            if(nums[i] != nums[correct_index]){
                swap(nums,i,correct_index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1){
                ans.add(j + 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
       List<Integer> ans = findDisappearedNumbers(nums);
        System.out.println(ans);
    }
}