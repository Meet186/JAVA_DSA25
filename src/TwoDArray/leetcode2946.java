package TwoDArray;

public class leetcode2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int future;
                if (i % 2 == 0) { // even row → right shift
                    future = (j + k) % n;
                } else { // odd row → left shift
                    future = (j - k + n) % n;
                }
                if (mat[i][j] != mat[i][future]) {
                    return false;
                }
            }
        }
        return true;
    }
}
