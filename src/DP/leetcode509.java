package DP;

import java.util.Arrays;

public class leetcode509 {
    public int solve(int n,int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1,dp) + solve(n-2,dp);
    }
    public int fib(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    // Bottom up
    public int fib2(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    // more optimize
    public int fib3(int n) {
        if(n <= 1) return n;
        int a = 0; // 0th fib
        int b = 1; // 1st fib
        int c = 0;
        for(int i=1; i<n; i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;

    }
}
