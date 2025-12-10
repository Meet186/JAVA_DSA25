package DP.twoD_DP;

public class leetcode64 {
    // Bottom-up
    public int solve(int row,int col,int[][] grid,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(row >= m || col >= n) return Integer.MAX_VALUE;
        if(row == m-1 && col == n-1) return grid[row][col];
        if(dp[row][col] != -1) return dp[row][col];
        int right = solve(row+1,col,grid,dp);
        int down = solve(row,col+1,grid,dp);
        return dp[row][col] = grid[row][col] + Math.min(right,down);

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0,grid,dp);
    }
    // Top-Down
    public int minPathSum2(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i == 0 && j == 0) continue;
                else if(i == 0) arr[i][j] += arr[i][j-1];
                else if(j == 0) arr[i][j] += arr[i-1][j];
                else arr[i][j] += Math.min(arr[i][j-1],arr[i-1][j]);
            }
        }
        return arr[m-1][n-1];
    }


}
