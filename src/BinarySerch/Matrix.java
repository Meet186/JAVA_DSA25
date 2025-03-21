package BinarySerch;

import java.util.Arrays;

public class Matrix {
    static int[] serch(int[][] matrix,int target){
        int row = 0;
        int col = matrix.length-1;

        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return new int[]{row,col};
            if(matrix[row][col] < target) row++;
            else col--;

        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {10,20,45},
                {55,58,60},
                {80,90,100}
        };

        System.out.println(Arrays.toString(serch(matrix,102)));
    }
}
