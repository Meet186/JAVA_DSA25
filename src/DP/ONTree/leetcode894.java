package DP.ONTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class leetcode894 {

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
   }

    public List<TreeNode> allPossibleFBT(int n) {
     return solve(n);
    }
    private  List<TreeNode> solve(int n ){
        if(n % 2 == 0) {
            List<TreeNode> empty = new ArrayList<>();
            return  empty;
        }
        if(n  == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> empty = new ArrayList<>();
            empty.add(root);
            return  empty;
        }

        List<TreeNode> ans = new ArrayList<>();
        for(int i=1; i<n; i+=2){
            List<TreeNode> left = solve(i);
            List<TreeNode> right = solve(n-i-1);

            for(var l : left){
                for(var r : right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }

            }

        }
        return ans;
    }
}
