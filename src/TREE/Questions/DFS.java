package TREE.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class DFS {
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
    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;

    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = 1 +  maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        int max = Math.max(leftDepth,rightDepth);
        return max;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        if(p == null || q == null) return null;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int r = preorder[0];
        int idx = 0;
        while(inorder[idx] != r){
            idx++;
        }
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,idx+1),Arrays.copyOfRange(inorder,0,inorder.length));
        node.right = buildTree(Arrays.copyOfRange(preorder,idx+1,preorder.length),Arrays.copyOfRange(inorder,idx+1,inorder.length));
        return  node;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.val == targetSum && root.left == null && root.right == null ) return true;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    private int helper(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) return sum;
        return helper(root.left,sum) + helper(root.right,sum);
    }
    public int sumNumbers(TreeNode root) {
        return   helper(root,0);

    }

    public boolean pathexist(TreeNode root,int[] arr){
        if(root == null){
            return arr.length == 0;
        }
        return helper(root,arr,0);

    }

    private boolean helper(TreeNode root, int[] arr, int level) {
        if(root == null) return false;
        if(level >= arr.length || root.val != arr[level]) return false;
        if(root.left == null && root.right == null && root.val == arr.length-1) return true;
        return helper(root.left,arr,level + 1) || helper(root.right,arr,level + 1);

    }

    public int pathsumCount(TreeNode root,int sum){
        List<Integer> path = new ArrayList<>();
      return helper(root,path,sum);

    }

    private int helper(TreeNode root, List<Integer> path, int sum) {
        if(root == null) return 0;
        path.add(root.val);
        int count = 0;
        int s = 0;
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()){
            s += itr.previous();
            if(s == sum) count++;
        }
        count += helper(root.left,path,sum) + helper(root.right,path,sum);
        path.remove(path.size()-1);
        return count;

    }


}

