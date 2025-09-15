package Backtracking;

public class Sudokusolve {

    static int check = 0;
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
        check = 0;
    }
    static void helper(char[][] board,int row,int col){
        if(row == 9){
            check = 1;
            return;
        }
        else if(board[row][col] != '.') {
            if(col != 8){
               helper(board,row,col+1);
            } else {
                helper(board,row+1,0);
            }
        } else { // board[row][col] == '.'
            for(char ch = '1'; ch <= '9'; ch++){
                if(isValid(board,row,col,ch)){
                    board[row][col] = ch;
                    if(col != 8){
                        helper(board,row,col+1);
                    } else {
                        helper(board,row+1,0);
                    }
                    if(check == 1) return;
                    board[row][col] = '.';
                }
            }
        }
    }

    static boolean isValid(char[][] board,int row,int col,char ch){
        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == ch) return false;
        }
        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) return false;
        }
        // check 3×3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == ch) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
