package DP.knapsack;

import java.util.List;

public class leetcode2915 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            // target -> 0 || index -> nums.length
            int[][] dp = new int[nums.size()][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -2;

            }

        }
            return helper(0,nums,target,dp);
    }
    private int helper(int index,List<Integer> nums, int target,int[][] dp){
        if(index == nums.size()){
            if(target == 0) return 0;
            else return -2;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int skip = helper(index + 1, nums, target,dp);

        int take = -1;
        if (target - nums.get(index) >= 0) {
            int res = helper(index + 1, nums, target - nums.get(index),dp);
            if (res != -1) {
                take = 1 + res;
            }
        }

        return dp[index][target] = Math.max(skip, take);

    }
}
