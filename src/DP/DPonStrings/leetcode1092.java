package DP.DPonStrings;

import java.util.Arrays;

public class leetcode1092 {

      // LENGTH OF shortestCommonSupersequence
//    public int longestCommonSubsequence(String text1, String text2) {
//        StringBuilder a = new StringBuilder(text1);
//        StringBuilder b = new StringBuilder(text2);
//        int m = a.length();
//        int n = b.length();
//        // m ->  0 || n -> 0
//        int[][] dp = new int[m + 1][n + 1];
//        for(int[] num : dp){
//            Arrays.fill(num,-1);
//        }
//        return lcs(m-1,n-1,a,b,dp);
//
//    }
//
//    private int lcs(int i, int j, StringBuilder a, StringBuilder b,int[][] dp) {
//        if(i < 0 || j < 0) return 0;
//        if(dp[i][j] != -1) return dp[i][j];
//        if(a.charAt(i) == b.charAt(j)){
//            return dp[i][j] =  1 + lcs(i-1,j-1,a,b,dp);
//        } else {
//            return dp[i][j] =  Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp));
//        }
//    }
//    public int shortestCommonSupersequence(String str1, String str2) {
//        int ans = str1.length() - longestCommonSubsequence(str1,str2) + str2.length() - longestCommonSubsequence(str1,str2) + longestCommonSubsequence(str1,str2);
//        return ans;
//    }


    class Solution {

        public String lcsString(String a, String b){
            int m = a.length();
            int n = b.length();
            int[][] dp = new int[m+1][n+1];

            // Build DP
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n ; j++) {
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] =  1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }

            // Reconstruct LCS
            StringBuilder str = new StringBuilder();
            int i = m, j = n;

            while (i > 0 && j > 0){
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    str.append(a.charAt(i-1));
                    i--;
                    j--;   // ✅ move diagonally
                }
                else if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                } else {
                    j--;
                }
            }

            return str.reverse().toString();
        }

        public String shortestCommonSupersequence(String str1, String str2) {

            String lcs = lcsString(str1, str2);

            int i = 0, j = 0, k = 0;
            StringBuilder ans = new StringBuilder();

            while (i < str1.length() && j < str2.length() && k < lcs.length()){

                while (str1.charAt(i) != lcs.charAt(k)){
                    ans.append(str1.charAt(i));
                    i++;
                }

                while (str2.charAt(j) != lcs.charAt(k)){
                    ans.append(str2.charAt(j));
                    j++;
                }

                ans.append(lcs.charAt(k));
                i++; j++; k++;
            }

            // Remaining
            while (i < str1.length()){
                ans.append(str1.charAt(i++));
            }

            while (j < str2.length()){
                ans.append(str2.charAt(j++));
            }

            return ans.toString();
        }
    }
}
