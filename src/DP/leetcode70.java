package DP;
import java.util.*;

public class leetcode70 {
    public int solve(int n,int[] dp){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        int one = solve(n-1,dp);
        int two = solve(n-2,dp);
        return dp[n] = one + two;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);

    }

    // Bottom up
    public int climbStairs2(int n) {
        if(n <= 3){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
