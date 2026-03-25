package TwoDArray;

public class leetcode3546 {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        int totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
                rowSum[i] += grid[i][j];
                colSum[j] +=  grid[i][j];
            }
        }
        if(totalSum % 2 != 0) return false;
        long upper = 0;
        // horizantal
        for (int i = 0; i < m-1; i++) {
            upper += rowSum[i];
            if(upper == totalSum-upper) return true;
        }

        long left = 0;
        // vertical
        for (int i = 0; i < n-1; i++) {
            left += colSum[i];
            if(left == totalSum-left) return true;
        }

        return false;
    }
}
