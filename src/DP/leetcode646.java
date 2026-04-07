package DP;

import java.util.Arrays;

public class leetcode646 {


    public int findLongestChain(int[][] nums) {
        int n = nums.length;

        // sort by second element (end)
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // each pair itself

            for (int j = 0; j < i; j++) {
                if (nums[j][1] < nums[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
    public static void main(String[] args) {


    }
}
