package KARPRABIN;

import java.util.*;



public class test {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // fill the board with .
        for(int i=0; i<n; i++){ // for row
            for(int j=0; j<n; j++){ //  for coloum
                board[i][j] = '.';
            }
        }
        helper(board,0,ans); // pass by reference
        return ans;
    }

    public void helper(char[][] board,int row, List<List<String>> ans){
        int n = board.length;
        if(row == n-1){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    str += board[i][j];
                }
                temp.add(str);
            }
            ans.add(temp);
            return; // imp because of call stack
        }
        for (int j = 0; j < n ; j++) {
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                helper(board, row + 1, ans);
                board[row][j] = '.';
            }
        }

    }


    public boolean isSafe(char[][] board,int row,int col){
        int n = board.length;
        // check row
        for (int i = 0; i < n; i++) {
            if(board[row][i] == 'Q') return false;
        }
        // for coloumn
        for (int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') return false;
        }
        // check all for directions
        int i = row;
        int j = col;

        // EAST
        while (i >=0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        // WEST
        i = row;
        j = col;
        while (i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        // SOUTH
        while (i < n && j >= 0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        // NORTH
        i = row;
        j = col;
        while (i < n && j < n){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        // if all condition match
        return true;
    }
}
