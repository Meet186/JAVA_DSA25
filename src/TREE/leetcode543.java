package TREE;

public class leetcode543 {
    public static class TreeNode {
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
        public static int diameterOfBinaryTree(TreeNode root) {
           if(root == null || root.left == null && root.right == null) return 0;
           int left = diameterOfBinaryTree(root.left);
           int right = diameterOfBinaryTree(root.right);
           int mid = hightofTree(root.left) + hightofTree(root.right);
           if(root.left != null) mid++;
           if(root.right != null) mid++;
           int max = Math.max(left,Math.max(right,mid));

           return max;
        }

        static int hightofTree(TreeNode root){
            if(root == null || root.left == null && root.right == null) return 0;
            return 1 + (Math.max(hightofTree(root.left),hightofTree(root.right)));
        }

        public static int diameterOfBinaryTree2(TreeNode root) {
            if(root == null) return 0;
            int result[] = {Integer.MIN_VALUE};
            solve(root,result);
            return result[0];
        }

        private static int solve(TreeNode root, int[] result) {
          if(root == null) return 0;
          int left = solve(root.left,result);
          int right = solve(root.right,result);
          result[0] = Math.max(result[0],left+right);
          return Math.max(left,right) + 1;
        }


    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(TreeNode.diameterOfBinaryTree2(root));
    }
}
