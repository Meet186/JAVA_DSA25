package DP.twoD_DP;

public class leetcode62 {
    private int solve(int row,int col,Integer m,Integer n,int[][] dp){
        if(row >= m || col >= n) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return  dp[row][col];
        int rightWay = solve(row+1,col,m,n,dp);
        int downWay = solve(row,col+1,m,n,dp);
        return dp[row][col] = rightWay + downWay;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0,m,n,dp);
    }
    // tabulation
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
