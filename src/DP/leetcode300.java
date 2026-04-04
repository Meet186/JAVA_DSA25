package DP;

public class leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
