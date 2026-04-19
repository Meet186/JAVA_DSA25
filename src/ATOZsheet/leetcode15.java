package ATOZsheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n-2 ; i++) {
            int left = i+1;
            int right = n-1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }


        }
        return ans;
    }
}
