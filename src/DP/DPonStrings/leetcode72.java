package DP.DPonStrings;

import java.util.Arrays;

public class leetcode72 {
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b =new StringBuilder(word2);
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] num : dp){
            Arrays.fill(num,-1);
        }
        return helper(m-1,n-1,a,b,dp);
    }

    private int helper(int i, int j, StringBuilder a, StringBuilder b,int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] =  helper(i-1,j-1,a,b,dp);
        } else {
            int delete =  1 + helper(i-1,j,a,b,dp);
            int insert = 1 + helper(i,j-1,a,b,dp);
            int replace = 1 + helper(i-1,j-1,a,b,dp);
            return dp[i][j] =  Math.min(delete,Math.min(insert,replace));
        }
    }

    public int minDistance2(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1];
                } else {
                    int delete =  1 + dp[i-1][j];
                    int insert = 1 + dp[i][j-1];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] =  Math.min(delete,Math.min(insert,replace));
                }

            }
        }

     return   dp[m][n];
    }
}
