package TREE.Questions;

import java.util.*;


public class leetcode297 {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public class Codec {

        private TreeNode buildTree( Queue<String> queue){
            if(queue.size() == 0) return null;
            String peek = queue.poll();
            if(peek.equals("x")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(peek));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "x";
            }
            String left = serialize(root.left);
            String right = serialize(root.right);
            return root.val + "," + left + "," + right;
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String arr[] = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for(int i=0; i<arr.length; i++){
                queue.add(arr[i]);
            }
            TreeNode root = buildTree(queue);
            return root;
        }
    }
}
