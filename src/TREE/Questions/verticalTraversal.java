package TREE.Questions;

import TREE.test;

import java.util.*;

public class verticalTraversal {

   public static class pair {
       int hd;
       TreeNode node;

       public pair(int hd, TreeNode node) {
           this.hd = hd;
           this.node = node;
       }
   }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<pair> queue = new ArrayDeque<>();
        int max = 0;
        int min = 0;
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        queue.offer(new pair(0,root));
        while (!queue.isEmpty()){
            pair curr = queue.poll();
            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.node.val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.val);
                map.put(curr.hd, temp);
            }
            max = Math.max(max,curr.hd);
            min = Math.min(min, curr.hd);
            if(curr.node.left != null){
                queue.add(new pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right != null){
                queue.add(new pair(curr.hd+1, curr.node.right));
            }


        }

        // put the map entries in ans
        for (int i = min; i <= max; i++) {
           List<Integer> temp = map.get(i);
           Collections.sort(temp);
           ans.add(temp);
        }
        return ans;
    }
}
