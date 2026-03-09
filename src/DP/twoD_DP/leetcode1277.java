class leetcode1277{
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for(int i=0; i<m; i++){ // row
            for(int j=0; j<n; j++){ // col
                if(matrix[i][j] == 0) continue;
                if(i != 0 && j != 0){
                    matrix[i][j] = Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                }
                count += matrix[i][j];
            }
        }
        return count;
    }
}