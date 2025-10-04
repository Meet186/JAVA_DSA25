package Backtracking;

public class validSudoku {
    // https://leetcode.com/problems/valid-sudoku/?envType=daily-question&envId=2025-09-15
    private static boolean check(char[][] board,int row,int col,char ch){
        // check row
        for (int j = 0;  j < 9; j++) {
            if(board[row][j] == ch) return false;
        }
        // check col
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == ch) return false;
        }
        // check 3*3 Matrix
        int startRow = row/3*3;
        int startcol = col/3*3;

        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startcol; j < startcol+3; j++) {
                if(board[i][j] == ch) return false;

            }

        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if(ch == '.') continue;
                board[i][j] = '.'; // for compare other value
                if(!check(board,i,j,ch)) return false;
                board[i][j] = ch;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}