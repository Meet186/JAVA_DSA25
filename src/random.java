import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class random {
   static void maze4direction(String p , boolean[][] isvisited,int row,int col){
       if(row == isvisited.length-1 && col == isvisited[0].length-1){
           System.out.println(p);
           return;
       }
       if(!isvisited[row][col]) return;
       isvisited[row][col] = false;
       if(row < isvisited.length-1){
           maze4direction("D"+p,isvisited,row+1,col);
       }
       if(col < isvisited[0].length-1){
           maze4direction("R"+p,isvisited,row,col+1);
       }
       if(row > 1){
           maze4direction("L"+p,isvisited,row-1,col);
       }
       if(col > 1){
           maze4direction("U"+p,isvisited,row,col-1);
       }
       isvisited[row][col] = true;
   }
    public static void main(String[] args) {
           boolean[][] isVisited = {
                   {true,true,true},
                   {true,true,true},
                   {true,true,true},

           };
        maze4direction("",isVisited,0,0);
    }


}
