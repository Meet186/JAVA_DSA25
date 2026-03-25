package DP.DPonStrings;

import java.util.Arrays;

public class leetcode583 {

    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] num : dp){
            Arrays.fill(num,-1);
        }
        int lcs =  helper(m-1,n-1,a,b,dp);
        return m-lcs + n-lcs;

    }

    private int helper(int i, int j, StringBuilder a, StringBuilder b,int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] =  1 + helper(i-1,j-1,a,b,dp);
        } else {
            return dp[i][j] =  Math.max(helper(i-1,j,a,b,dp),helper(i,j-1,a,b,dp));
        }
    }
}
