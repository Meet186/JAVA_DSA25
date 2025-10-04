package Backtracking;

public class leetcode980 {
    int start_X = 0;
    int start_Y = 0;
    int noOfobstacles  = 0;
    int count = 0;

    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0){
                    noOfobstacles++;
                } else if (grid[i][j] == 1) {
                    start_X = i;
                    start_Y = j;
                    noOfobstacles++; // because 1 is also a obstacles
                }

            }
        }
        helper(grid,0,start_X,start_Y);
        return count;
    }

    public void helper(int[][] grid,int currcount,int start_X,int start_Y){
        if(start_X < 0 || start_X >= grid.length || start_Y < 0 || start_Y >= grid[0].length) return;
        if(grid[start_X][start_Y] == -1) return;
        if(grid[start_X][start_Y] == 2){
            if(currcount == noOfobstacles){
                count++;
                return;
            }
        }
        int temp = grid[start_X][start_Y];
        grid[start_X][start_Y] = -1;
        helper(grid, currcount+1, start_X+1, start_Y);
        helper(grid, currcount+1, start_X-1, start_Y);
        helper(grid, currcount+1, start_X, start_Y+1);
        helper(grid, currcount+1, start_X, start_Y-1);
        grid[start_X][start_Y] = temp; // backtrack

    }


    public static void main(String[] args) {

    }
}
