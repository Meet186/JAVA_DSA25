package TREE.Questions;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class DFSusingStack {

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
        }

        public static void dfsStack(TreeNode root){
            if(root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
        }


    public static void main(String[] args) {

    }
}
