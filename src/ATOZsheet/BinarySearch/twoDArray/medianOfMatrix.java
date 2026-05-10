package ATOZsheet.BinarySearch.twoDArray;
public class medianOfMatrix {
    private int[] findSearchSpace(int[][] matrix){
        int n = matrix[0].length;
        // given matrix is sorted by row
        // so check 0 and n-1 row only for lowest and highest value
        int si = Integer.MAX_VALUE; // lowest
        int ei = Integer.MIN_VALUE; // highest
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] < si){
               si = matrix[i][0];
            }
            if(matrix[i][n-1] > ei){
                ei = matrix[i][n-1];
            }
        }
        return new int[] {si,ei};
    }
    public int findMedian(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int requiredSmallerEl = (m*n)/2;
        int[] searchSpace = findSearchSpace(matrix);
        int si = searchSpace[0];
        int ei = searchSpace[1];
        while (si <= ei){
            int mid = si + (ei-si)/2;
            int countSmallerThanMid = find(matrix,mid);
            if(countSmallerThanMid <= requiredSmallerEl){
                si = mid + 1;
            } else {
                ei = mid-1;
            }
        }
        return si;

    }
    private int find(int[][] matrix, int mid) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            cnt += upperBound(matrix[i],mid );

        }
        return cnt;
    }

    private int upperBound(int[]arr,int k){
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {

            int mid = si + (ei - si) / 2;

            if (arr[mid] <= k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return si;
    }
}
