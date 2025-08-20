package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class allpath {
    static void allPath(String p, boolean[][] isVisited , int r,int c){
        if(r == isVisited.length-1 && c == isVisited[0].length-1){
            System.out.println(p);
            return;
        }
        if(!isVisited[r][c]) return;
        isVisited[r][c] = false;
        if(r < isVisited.length-1){
            allPath("D"+p,isVisited,r+1,c);
        }
        if(c < isVisited[0].length-1){
            allPath("R"+p,isVisited,r,c+1);
        }
        if(r > 1){
            allPath("L"+p,isVisited,r-1,c);
        }
        if(c > 1){
            allPath("U"+p,isVisited,r,c-1);
        }
        isVisited[r][c] = true;
    }

    static List<String> allPathReturn(String p, boolean[][] isVisited , int r, int c){
        List<String> list = new ArrayList<>();

        if(r == isVisited.length-1 && c == isVisited[0].length-1){
            list.add(p);
            return list;
        }
        if(!isVisited[r][c]) return list ;
        isVisited[r][c] = false;
        List<String> temp = new ArrayList<>();
        if(r < isVisited.length-1){
           temp.addAll( allPathReturn("D"+p,isVisited,r+1,c) );
        }
        if(c < isVisited[0].length-1){
           temp.addAll( allPathReturn("R"+p,isVisited,r,c+1) );
        }
        if(r > 1){
           temp.addAll( allPathReturn("L"+p,isVisited,r-1,c));
        }
        if(c > 1){
           temp.addAll( allPathReturn("U"+p,isVisited,r,c-1) );
        }
        isVisited[r][c] = true;
        return temp;
    }


    public static void main(String[] args) {
        boolean[][] isVisited = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        System.out.println( allPathReturn("",isVisited,0,0));
    }
}
