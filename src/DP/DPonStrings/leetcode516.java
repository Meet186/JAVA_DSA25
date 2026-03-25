package DP.DPonStrings;

import java.util.Arrays;

public class leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int[] num : dp){
            Arrays.fill(num,-1);
        }
        return helper(0,n-1,s,dp);
    }

    private int helper(int i,int j ,String s,int[][] dp) {
       if(i > j) return 0;
       if(i == j) return 1;
       if(dp[i][j] != -1) return dp[i][j];

       if(s.charAt(i) == s.charAt(j)){
           return dp[i][j] =  2 + helper(i+1,j-1,s,dp);
       } else {
           return   dp[i][j] = Math.max(helper(i+1,j,s,dp),helper(i,j-1,s,dp));
       }
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single character = palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill table (bottom-up)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

}
