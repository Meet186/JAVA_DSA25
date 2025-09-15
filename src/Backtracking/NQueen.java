package Backtracking;

public class NQueen {

    static void NQueen(int row){
        char[][] board = new char[row][row];
        for (int i = 0; i < row; i++) {
             for (int j = 0; j < row ; j++) {
                 board[i][j] = 'X';
            }
        }
        helper(board,0);
    }

    static void helper(char[][] board,int row){
        int n = board.length;
        if(row == n-1){
            printBoard(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                helper(board,row+1);
                board[row][i] = 'X';

            }
        }
    }
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        for (int j = 0; j < n; j++) { // check entire East & West
            if (board[row][j] == 'Q') return false;
        }

        for (int i = 0; i < n; i++) { // check entire North & South
            if(board[i][col] == 'Q') return false;
        }
        int i = row;
        int j = col;

        while (i >= 0 && j < n){ // Check South East
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j < n){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }

        i = row;
        j = col;
        while (i < n && j >= 0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        i = row;
        j = col;

        while (i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        return true;
    }

    static void printBoard(char board[][]){
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
            NQueen(4);
    }
}
