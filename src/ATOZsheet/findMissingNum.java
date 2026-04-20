package ATOZsheet;

import java.util.Arrays;

public class findMissingNum {
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        // applay cyclic sort to sort {applay any other also}
        int i = 0;
        while (i < nums.length){
            int correct_Index = nums[i] - 1; // for zero based indexing
            if(nums[i] != nums[correct_Index]){
                swap(nums,i,correct_Index);
            } else {
                i++;
            }
        }
        // iterate over array to find missing num
        for (int j = 0; j < nums.length ; j++) {
            if(nums[j]-1 != j){
                return new int[]{nums[j],j+1};
            }

        }
        return new int[] {-1};

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 7, 5, 7};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
    }
}
