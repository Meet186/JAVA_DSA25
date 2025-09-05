package Backtracking;

import java.util.ArrayList;

public class maze {
    static int count(int r,int c){
            if(r == 1 || c == 1){
                return 1;

            }
            int left = count(r-1,c);
            int right = count(r,c-1);
            return left + right;
    }
    static void path(String p,int r,int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            path("D" + p,r-1,c);
        }
        if(c > 1){
            path("R" + p,r,c-1);
        }
    }

    static ArrayList<String> pathreturn(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> temp = new ArrayList<>();
        if(r > 1){
            temp.addAll(pathreturn("D" + p,r-1,c));
        }
        if(c > 1){
            temp.addAll(pathreturn("R" + p,r,c-1));
        }

        return temp;

    }

    static ArrayList<String> pathreturnDiognal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> temp = new ArrayList<>();
        if(r > 1 && c > 1){
            temp.addAll(pathreturnDiognal("D" + p,r-1,c-1));
        }
        if(r > 1){
            temp.addAll(pathreturnDiognal("V" + p,r-1,c));
        }
        if(c > 1){
            temp.addAll(pathreturnDiognal("H" + p,r,c-1));
        }

        return temp;
    }

   static void pathRestiction(String p , boolean maze[][],int r,int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        if(r < maze.length-1){
            pathRestiction("D" + p,maze,r+1,c);
        }
        if(c < maze[0].length-1){
            pathRestiction("R" + p,maze,r,c+1);
        }
   }
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
//        pathRestiction("",board,0,0);
          path("",4,4);
    }
}
