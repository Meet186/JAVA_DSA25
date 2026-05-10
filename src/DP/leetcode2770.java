package DP;

import java.util.Arrays;

public class leetcode2770 {
    private int solve(int[] nums, int i, int target,int[] dp) {
        if (i == 0) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];

        int ans = Integer.MIN_VALUE;

        for (int j = i - 1; j >=0 ; j--) {

            if (Math.abs(nums[i] - nums[j]) <= target) {

                int next = solve(nums, j, target,dp);

                if (next != Integer.MIN_VALUE) {
                    ans = Math.max(ans, 1 + next);
                }
            }
        }

        return dp[i] =  ans;
    }

    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans = solve(nums, nums.length-1, target,dp);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public int bottomUp(int[] nums,int target){
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {

                if (Math.abs(nums[i] - nums[j]) <= target
                        && dp[j] != Integer.MIN_VALUE) {

                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[0] == Integer.MIN_VALUE ? -1 : dp[0];
    }
}
