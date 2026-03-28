package DP.ONTree;

import java.util.Arrays;

public class leetcode96 {
    public int numTrees(int n) {
     if(n <= 1) return 1;
     int[] dp = new int[n+1];
     Arrays.fill(dp,-1);
     return solve(n,dp);
    }

    private int solve(int n, int[] dp) {
        if(n <= 1) return 1;
       if(dp[n] != -1) return dp[n];
       int ans = 0;
       for (int i = 1; i <= n ; i++) {
            ans+= solve(i-1,dp) * solve(n-i,dp);
        }
        return dp[n] = ans;
    }

    // bottom up
    public int numTrees2(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] += dp[j-1] *dp[i-j];
            }
        }
        return dp[n];
    }

}
