package DP;
import java.util.Arrays;
public class leetcode1911 {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums.length-1, nums, 1, dp);
    }
    private long solve(int idx, int[] nums, int flag, long[][] dp) {
        if (idx <  0) return 0;

        if (dp[idx][flag] != -1) return dp[idx][flag];

        long skip = solve(idx - 1, nums, flag, dp);

        long val = nums[idx];
        if (flag == 0) {
            val = -val;
        }

        long take = val + solve(idx - 1, nums, 1 - flag, dp);

        return dp[idx][flag] = Math.max(skip, take);
    }

    public long maxAlternatingSum2(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];

        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];


            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - val);


            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + val);
        }

        return dp[n][1];
    }



}
