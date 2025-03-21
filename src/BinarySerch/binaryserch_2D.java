package BinarySerch;
import java.util.Arrays;
public class binaryserch_2D {
    static int[] serchIn_2D(int[][] matrix,int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while (start <= end){
            int mid = start + (end-start)/2; //-> Give 1D index
            /*
            for Row > 1D -> 2D = 1D/number of column
            for COl > 1D -> 2D = 1D%number of column
             */
            if(matrix[mid/n][mid%n] == target) return new int[] {mid/n,mid%n};
            else if (matrix[mid/n][mid%n] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] ans = serchIn_2D(matrix,5);
        System.out.println(Arrays.toString(ans));
    }

}
