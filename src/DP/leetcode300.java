package DP;

import java.util.Arrays;

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

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1]; // prev from -1 → n-1 (shifted by +1)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, -1, nums, dp);
    }

    private int solve(int idx, int prev, int[] nums, int[][] dp) {
        if (idx == nums.length) return 0;

        if (dp[idx][prev + 1] != -1) return dp[idx][prev + 1];

        // skip
        int skip = solve(idx + 1, prev, nums, dp);

        // take
        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + solve(idx + 1, idx, nums, dp);
        }

        return dp[idx][prev + 1] = Math.max(skip, take);
    }

}
