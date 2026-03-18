package TwoDArray;

public class leetcode3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {

                if(i > 0) grid[i][j] += grid[i-1][j];
                if(j > 0) grid[i][j] += grid[i][j-1];
                if(i > 0 && j > 0) grid[i][j] -= grid[i-1][j-1]; // FIXED

                if(grid[i][j] <= k){  // sometimes <= is required (depends on problem)
                    count++;
                }
            }
        }
        return count;
    }
}
