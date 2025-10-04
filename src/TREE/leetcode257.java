package TREE;
import java.util.*;

import static TREE.leetcode257.TreeNode.binaryTreePaths;

public class leetcode257 {

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static void helper(TreeNode root,List<String> ans ,String s ){
            if(root == null) return;
            if(root.left == null && root.right == null) {
                s += root.val;
                ans.add(s);
                return;
            }
            helper(root.left,ans,s+root.val+"->");
            helper(root.right,ans,s+root.val+"->");
        }

        public static List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            helper(root,ans,"");
            return ans;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));

    }
}
