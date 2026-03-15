package DP.knapsack;

public class leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,target);
    }
    private int helper(int index,int[]nums,int target){
        if(index == nums.length){
            if(target == 0) return 1;
            else  return 0;
        }

        int plus = helper(index+1,nums,target+nums[index]);
        int minus = helper(index+1,nums,target-nums[index]);
        return plus + minus;

    }
}
