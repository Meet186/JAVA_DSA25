package Backtracking;
import java.util.Arrays;
public class allPathPrint {
    static void allPathPrint(String p, boolean[][] isVisited , int r,int c , int[][] path , int step){
        if(r == isVisited.length-1 && c == isVisited[0].length-1){
            path[r][c] = step;
            for(int[] el : path){
                System.out.println(Arrays.toString(el));
            }
            System.out.println();
            System.out.println(p);
            return;
        }
        if(!isVisited[r][c]) return;
        isVisited[r][c] = false;
        path[r][c] = step;
        if(r < isVisited.length-1){
            allPathPrint("D"+p,isVisited,r+1,c,path,step+1);
        }
        if(c < isVisited[0].length-1){
            allPathPrint("R"+p,isVisited,r,c+1,path,step+1);
        }
        if(r > 1){
            allPathPrint("L"+p,isVisited,r-1,c,path,step+1);
        }
        if(c > 1){
            allPathPrint("U"+p,isVisited,r,c-1,path,step+1);
        }
        isVisited[r][c] = true;
        path[r][c] = 0;
    }
    public static void main(String[] args) {
        boolean[][] isVisited = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] path = new int[isVisited.length][isVisited[0].length];
        allPathPrint("",isVisited,0,0,path,0);
    }
}
