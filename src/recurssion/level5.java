package recurssion;

import java.util.ArrayList;
import java.util.List;

public class level5 {
    static void pathPrint(String p,int r,int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            pathPrint(p+"R",r-1,c);
        }
        if(c > 1){
            pathPrint(p+"D",r,c-1);
        }
    }
    static List<String> mazeIn4DwithRestiction(String p , boolean[][] isVisited,int row,int col){
        List<String> list = new ArrayList<>();
        if(row == isVisited.length-1 && col == isVisited.length-1){
            list.add(p);
            return list;
        }
        if(!isVisited[row][col]) return list;
        isVisited[row][col] = false;
        List<String> temp = new ArrayList<>();
        // RIGHT
        if(row < isVisited.length-1){
            temp.addAll(mazeIn4DwithRestiction("R"+p,isVisited,row+1,col)) ;
        }
        //LEFT
        if(row > 1){
          temp.addAll(  mazeIn4DwithRestiction("L"+p,isVisited,row-1,col));
        }
        //DOWN
        if(col < isVisited.length-1){
          temp.addAll(  mazeIn4DwithRestiction("D"+p,isVisited,row,col+1));
        }
        //Up
        if(col > 1){
          temp.addAll(  mazeIn4DwithRestiction("U"+p,isVisited,row,col-1));
        }
        isVisited[row][col] = true;
        return temp;
    }
    static void permutation(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String left = p.substring(0,i);
            String rigth = p.substring(i,p.length());
            permutation(left + ch + rigth,up.substring(1));
        }
    }
    static List<List<Integer>> permutation(int[] arr){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] isVisited = new boolean[arr.length];
        helper(arr,temp,isVisited,list);
        return list;
    }
    static void helper(int[] arr,List<Integer> temp,boolean[] isVisited,List<List<Integer>> ans){
        if(temp.size() == arr.length){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                list.add(temp.get(i));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
          if(isVisited[i] == false){
              temp.add(arr[i]);
              isVisited[i] = true;
              helper(arr, temp, isVisited, ans);
              isVisited[i] = false;
              temp.remove(temp.size()-1);
          }


        }
    }
    public static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int el : arr){
            int n =result.size();
            for (int i = 0; i <n; i++) {
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(el);
                result.add(temp);
            }
        }
        return result;
    }

    static List<List<Integer>> permutation2(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        helperForpermutation2(arr,0,ans);
        return ans;
    }

    private static void helperForpermutation2(int[] arr, int idx, List<List<Integer>> ans) {
        if(idx == arr.length-1) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }
            ans.add(temp);
        }
            for (int i = idx; i < arr.length ; i++) {
                swap(arr,i,idx);
                helperForpermutation2(arr,idx+1,ans);
                swap(arr,i,idx);

            }
        }

    static void swap(int[] arr , int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
//        pathPrint("",4,4);
//        boolean[][] isVisited = {
//                {true,true,true},
//                {true,false,true},
//                {true,true,true},
//        };
//       List<String> ans = mazeIn4DwithRestiction("",isVisited,0,0);
//        System.out.println(ans);
//        permutation("","123");
        int[] arr = {1,2,3};
        List<List<Integer>> ans = permutation2(arr);
        System.out.println(ans);
    }
}
