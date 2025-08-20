package Sorting;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-the-duplicate-number/
public class leetcode_287 {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int find_Duplicate(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1 );
            } else {
                int val = map.get(nums[i]);
                map.put(nums[i],val+1 );
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
    static int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n){
            if(nums[i] != i+1){
                int correct_index = nums[i] - 1;
                if(nums[i] != nums[correct_index]){
                    swap(nums,i,correct_index);
                } else {
                    return nums[i];
                }
            }
            else {
                i++;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,3};
        System.out.println(find_Duplicate(arr));
    }
}
