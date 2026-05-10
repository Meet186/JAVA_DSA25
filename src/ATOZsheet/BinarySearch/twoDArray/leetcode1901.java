package ATOZsheet.BinarySearch.twoDArray;

public class leetcode1901 {
    private int findMaxCol(int[][] mat, int row) {

        int col = 0;

        for (int j = 1; j < mat[0].length; j++) {
            if (mat[row][j] > mat[row][col]) {
                col = j;
            }
        }

        return col;
    }

    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int si = 0;
        int ei = rows - 1;

        while (si <= ei) {

            int mid = si + (ei - si) / 2;

            int col = findMaxCol(mat, mid);

            int up = mid > 0 ? mat[mid - 1][col] : -1;
            int down = mid < rows - 1 ? mat[mid + 1][col] : -1;

            if (mat[mid][col] > up && mat[mid][col] > down) {
                return new int[]{mid, col};
            }

            if (down > mat[mid][col]) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
