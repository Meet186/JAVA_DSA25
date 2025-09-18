package TREE;

public class leetcode110 {


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

    public static void main(String[] args) {

    }
    static int hightofTree(TreeNode root){
        if(root == null || root.left == null && root.right == null) return 0;
        return 1 + (Math.max(hightofTree(root.left),hightofTree(root.right)));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHight = hightofTree(root.left);
        if(root.left != null) leftHight++;
        int rightHight = hightofTree(root.right);
        if(root.right != null) rightHight++;
        int difference = Math.abs(leftHight-rightHight);
        if(difference > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
}
