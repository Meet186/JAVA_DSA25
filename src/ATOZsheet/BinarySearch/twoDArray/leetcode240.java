package ATOZsheet.BinarySearch.twoDArray;

public class leetcode240 {
    public boolean searchMatrix(int[][] mat, int target) {
        int row  = 0;
        int col = mat[0].length-1;

        while(col >=0 && row <= mat.length-1){
            if(mat[row][col] == target) return true;
            else if (target < mat[row][col]) col--;
            else row++;
        }
        return false;

    }
}
