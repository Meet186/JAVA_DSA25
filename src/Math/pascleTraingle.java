package Math;

public class pascleTraingle {
    static int[][] pascleTraingle(int n){
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[i+ 1];
            matrix[i][0] = matrix[i][i] = 1;
            for (int j = 1; j < i  ; j++) {
                matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
            }
        }
        return matrix;
    }
    static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row  = 4;

        for (int i = 0; i <=  row; i++) {
            int value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(value + " ");
                value = value * (i-j) / (j + 1);
            }

            System.out.println();
            
        }
    }
}
