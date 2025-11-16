package TREE.Questions;

import com.sun.source.tree.Tree;

public class AVLPractice {
    public class TreeNode {
        private int val;
       private TreeNode left;
       private TreeNode right;
       private int height;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(TreeNode root) {
        return root.height;
    }
    TreeNode root;

    public void insert(int val){
        root = insert(val,root);
    }

    private TreeNode insert(int val, TreeNode root) {
        if(root == null){
            root = new TreeNode(val);
            root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
            return root;
        }
        if(val < root.val){
            root.left = insert(val,root.left);
        }
        if(val > root.val){
            root.right = insert(val,root.right);
        }
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        return rotate(root);
    }

    public TreeNode rotate(TreeNode root){
        int balance = getHeight(root.left)-getHeight(root.right);

       if(balance > 1){
           // left side  heavy l-r
           if(getHeight(root.left.right) > getHeight(root.left.left)){
               root.left = leftRotate(root.left);
           }
           return rightRotate(root);
       }
       if(balance < -1){
           // right side heavy r-l
           if(getHeight(root.right.left) > getHeight(root.right.right)){
               root.right = rightRotate(root.right);
           }
           return leftRotate(root);

       }
        return root;
    }

    private TreeNode rightRotate( TreeNode p){
        TreeNode c = p.left;
        TreeNode t = c.right;

        c.right = p;
        p.left = t;
         p.height = Math.max(getHeight(p.left),getHeight(p.right) + 1);
         c.height = Math.max(getHeight(c.left),getHeight(c.right) + 1);
         return c;

    }
    private  TreeNode leftRotate(TreeNode p ){
        TreeNode c = p.right;
        TreeNode t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(getHeight(p.left),getHeight(p.right) + 1);
        c.height = Math.max(getHeight(c.left),getHeight(c.right) + 1);
        return c;

    }
}
