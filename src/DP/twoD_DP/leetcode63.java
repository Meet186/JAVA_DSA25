package DP.twoD_DP;

import java.util.Arrays;

public class leetcode63 {

        public int uniquePathsWithObstacles(int[][] arr) {
            int m = arr.length;
            int n = arr[0].length;
            int[][] dp = new int [m][n];
            for(int i = 0; i < m; i++) {
                Arrays.fill(dp[i], -1);
            }

            // If start or end is blocked
            if(arr[0][0] == 1 || arr[m-1][n-1] == 1) return 0;

            return solve(arr, 0, 0,dp);
        }

        private int solve(int[][] arr, int i, int j,int[][] dp) {
            int m = arr.length;
            int n = arr[0].length;

            // Boundary check
            if(i >= m || j >= n) return 0;

            if(dp[i][j] != -1) return dp[i][j];

            // Obstacle check
            if(arr[i][j] == 1) return 0;

            // Destination reached
            if(i == m-1 && j == n-1) return 1;

            int down = solve(arr, i+1, j,dp);
            int right = solve(arr, i, j+1,dp);

            return dp[i][j] =  down + right;
        }
    }

