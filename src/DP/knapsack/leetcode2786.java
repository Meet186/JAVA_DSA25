package DP.knapsack;

import java.util.Arrays;

public class leetcode2786 {
    public long maxScore(int[] nums, int x) {
        // index -> 0 to n parities - > odd || even 2
        long[][] dp = new long[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return nums[0] + helper(1,nums[0]%2, nums,x,dp);
    }
    private long helper(int index,int parities,int[] nums,int x,long[][] dp){
        if(index == nums.length) return 0;
        if(dp[index][parities] != -1) return dp[index][parities];
        long skip = helper(index + 1, parities, nums, x,dp);
        long pick = 0;
        if(nums[index] % 2 == parities){ // same - same
            pick = nums[index] + helper(index + 1, parities, nums, x,dp);
        } else {
            pick = nums[index] - x  + helper(index+ 1, parities^1, nums, x,dp);
        }
        return dp[index][parities] = Math.max(skip,pick);
    }
}
