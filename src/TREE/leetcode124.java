package TREE;

public class leetcode124 {
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


    int max_Sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       solve(root);
       return max_Sum;
    }
    private int solve(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));
        int path_Sum = root.val + left + right;
        max_Sum = Math.max(max_Sum,path_Sum);
        return root.val + Math.max(left,right);
    }


}
