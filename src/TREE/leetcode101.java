package TREE;
import java.util.*;

public class leetcode101 {
    public static class TreeNode {
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

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        public TreeNode inverted(TreeNode root) {
            if (root == null) return root;
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = inverted(right);
            root.right = inverted(left);
            return root;
        }



        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            root.left = inverted(root.left);
            return isSameTree(root.left, root.right);
        }
    }
}
