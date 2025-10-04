package TREE;

public class traverse {
    static void pretraverseTree(Node root){
        if(root == null) return;
        System.out.println(root.val);
        pretraverseTree(root.left);
        pretraverseTree(root.right);
    }
    static void inOrderTraversel(Node root){
        if(root == null) return;
        inOrderTraversel(root.left);
        System.out.println(root.val);
        inOrderTraversel(root.right);
    }
    static void postOrderTraversel(Node root){
        if(root == null) return;
        postOrderTraversel(root.left);
        postOrderTraversel(root.right);
        System.out.println(root.val);
    }
    static int countTreeNode(Node root){
        if(root == null) return 0;
        return (1 + countTreeNode(root.left) + countTreeNode(root.right));
    }
    static int maxOfNode(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(maxOfNode(root.left),maxOfNode(root.right)));
    }
    static int sumOfNode(Node root){
        if(root == null) return 0;
        return root.val + sumOfNode(root.left) + sumOfNode(root.right);
    }
    static int hightofTree(Node root){
        if(root == null) return 0;
        return 1 + (Math.max(hightofTree(root.left),hightofTree(root.right)));
    }
    static int hightofTreeByLevel(Node root){
        if(root == null ) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + (Math.max(hightofTreeByLevel(root.left),hightofTreeByLevel(root.right)));
    }
    static int minOfTree(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(minOfTree(root.left),minOfTree(root.right)));
    }
    static int productOfTree(Node root){
        if(root == null) return 1;
        return root.val * productOfTree(root.left) * productOfTree(root.right);
    }
    public static class Node {
        int val; // 0
        Node left; // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        b.right = e;
//        traverseTree(root);
//        System.out.println(countTreeNode(root));
//        System.out.println(sumOfNode(root));
//        System.out.println(maxOfNode(root));
//        System.out.println(hightofTree(root));
//        System.out.println(hightofTreeByLevel(root));
//        System.out.println(minOfTree(root));
//        System.out.println(productOfTree(root));
          postOrderTraversel(root);
    }

}
