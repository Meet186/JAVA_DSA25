package TREE;

import java.util.*;

public class leetcode113 {
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

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();
            helper(root, arr, ans, targetSum);
            return ans;
        }
        private void helper(TreeNode root, List<Integer> arr, List<List<Integer>> ans, int targetSum) {
            if (root == null) return;
            // Base Case
            if (root != null && root.left == null && root.right == null) { // A leaf node
                arr.add(root.val);
                if (root.val == targetSum) {
                    List<Integer> temp = new ArrayList<>();
                    for (int i = 0; i < arr.size(); i++) {
                        temp.add(arr.get(i)); // because pass by reference
                    }
                    ans.add(temp);
                }
                arr.remove(arr.size() - 1); // remove last el for backtrack for more possible ans
            }
            // Work
            arr.add(root.val);
            helper(root.left,arr,ans,targetSum- root.val); // left call work
            helper(root.right,arr,ans,targetSum- root.val); // right call work
            arr.remove(arr.size()-1); // Backtrack
        }

        public static void main(String[] args) {


        }

    }
}