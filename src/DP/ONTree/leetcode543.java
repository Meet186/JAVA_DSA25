package DP.ONTree;


import java.util.HashMap;
import java.util.Map;

public class leetcode543 {
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
    private int level(TreeNode root,Map<TreeNode,Integer> dp){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left = level(root.left,dp);
        int right = level(root.right,dp);
        dp.put(root,1 + Math.max(left,right));
        return dp.get(root);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Map<TreeNode,Integer> dp = new HashMap<>();
        return diameter(root,dp);
    }
    public int diameter(TreeNode root, Map<TreeNode,Integer> dp) {
        if(root == null) return 0;
        int mydia = level(root.left,dp) + level(root.right,dp);
        int leftdia = diameter(root.left,dp);
        int rightdia = diameter(root.right,dp);
        return Math.max(mydia,Math.max(leftdia,rightdia)) ;
    }
}
