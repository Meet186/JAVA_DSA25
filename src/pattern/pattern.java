package pattern;
public class pattern {
    static void pattern_No1(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern_No2(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern_No3(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < (n-row); col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern_No4(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern_No5(int n) {
        for (int row = 0; row < 2*n; row++) {
            int total_Col = row > n ? 2*n - row : row;
            for (int col = 0; col < total_Col; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    static void pattern_No6(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-i-1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern_No7(int n){
        for (int row = 0; row < 2*n; row++) {
            int total_Col = row > n ? 2*n - row : row;
            int total_spaces = n-total_Col;
            for (int space = 0; space < total_spaces; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < total_Col; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern_No8(int n){
        for (int row = 0; row < n; row++) {
            int total_Col = n-row;
            int total_Space = row;
            for (int space = 0; space < total_Space; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < total_Col; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern_No9(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(row == 0 || row == n-1 || col == 0 || col == n-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void pattern_No10(int n){
        for (int row = 1; row <= n; row++) {
            int total_space = n-row;
            for (int i = 0; i < total_space; i++) {
                System.out.print(" ");
            }
            for (int col = row; col >=1 ; col--) {
                System.out.print(col);
            }
            for (int col =2 ; col <= row ; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern_No11(int n){
        for (int row = 1; row <= 2*n - 1; row++) {
            int totol_col = row > n ? 2*n - row: row;
            int total_space = n-totol_col;
            for (int space = 0; space < total_space ; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= totol_col ; col++) {
                System.out.print(col);
            }
            for (int col = 2; col <= totol_col ; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern_No12(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n-row; col++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2*row; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < n-row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = n-1; row >0 ; row--) {
            for (int col = 0; col < n-row; col++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2*row; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < n-row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern_No13(int n){
        for (int row = 1; row < 2*n-1; row++) {
            int total_col = row > n ? 2*n-row : row;
            for (int space = 0; space < n-total_col; space++) {
                System.out.print("  ");
            }
            for (int col = total_col; col >= 1; col--) {
                System.out.print(col + " " );
            }
            for (int col = 2; col <= total_col; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern15(int n){
        for (int row = 1; row < 2*n ; row++) {
            int total_star = row > n ? 2*n-row : row;
            int total_Space = n - total_star;
            for (int space = 1; space <= total_Space ; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= total_star ; star++) {
                System.out.print("*");
            }
            for (int star = 2; star <= total_star ; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void patternNo14(int val){
        int original_val = val;
        int n = 2*val;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int indexAtEveyValue = original_val - Math.min(Math.min(row,col),Math.min(n-row,n-col));
                System.out.print(indexAtEveyValue);
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
       
    }
}

