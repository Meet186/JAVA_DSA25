package Sorting;

public class leetcode_41 {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correct_Index = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct_Index]){
                swap(nums,i,correct_Index);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                return j+1;
            }

        }

        return nums.length+1;
    }


}
