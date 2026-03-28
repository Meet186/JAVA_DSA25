package DP.DPonStrings;

import java.util.Arrays;

public class leetcode647 {
    // APPROACH - 1
//    public int countSubstrings(String s) {
//        int count = 0;
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j <n ; j++) {
//                if(checkPalindrome(s,i,j)){
//                    count++;
//                }
//
//            }
//
//        }
//        return count;
//    }
//
//    private boolean checkPalindrome(String s, int i, int j) {
//        while (i < j){
//            if(s.charAt(i) != s.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }


//    // APPROACH -> 2
//    public int countSubstrings(String s) {
//        int count = 0;
//        int n = s.length();
//        int[][] dp = new int[n + 1][n + 1];
//        for(int[] num : dp){
//            Arrays.fill(num,-1);
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j <n ; j++) {
//                if(checkPalindrome(s,i,j,dp)){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private boolean checkPalindrome(String s, int i, int j,int[][] dp) {
//      if(i > j ) return true;
//      if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
//      boolean ispal =  s.charAt(i) == s.charAt(j) && checkPalindrome(s,i+1,j-1,dp);
//        dp[i][j] = ispal ? 1 : 0;
//        return ispal;
//
//    }

        // APPROACH -> 3
//    public int countSubstrings(String s) {
//        int count = 0;
//        int n = s.length();
//        int[][] dp = new int[n + 1][n + 1];
//        for (int L = 1; L <= n ; L++) {
//            for (int i = 0; i + L - 1 < n; i++) {
//                int j = i + L - 1;
//                if(i == j) dp[i][j] = 1;
//                else if(i + 1 == j){
//                     if( s.charAt(i) == s.charAt(j)){
//                         dp[i][j] = 1;
//                     }
//                } else {
//                    if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
//                        dp[i][j] = 1;
//                    }
//                }
//                if(dp[i][j] == 1) count++;
//            }
//        }
//        return count;
//    }
}
