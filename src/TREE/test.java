package TREE;

public class test {
    public static class Node {
        int val;
        Node left;
        Node right;

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
        Node f = new Node(7);

        b.left = e;
        b.right = f;

        POSTtraverse(root);

    }

    static void pretraverse(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        pretraverse(root.left);
        pretraverse(root.right);
    }

    static void INtraverse(Node root) {
        if (root == null) return;
        INtraverse(root.left);
        System.out.println(root.val);
        INtraverse(root.right);
    }

    static int countTreeNode(Node root){
        if(root == null) return 0;
        return 1 + (countTreeNode(root.left)) + countTreeNode(root.right);
    }

    static int maxNode(Node root){
        if(root == null)  return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(maxNode(root.left),maxNode(root.right)));
    }

    static int minNode(Node root){
        if(root == null)  return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(maxNode(root.left),maxNode(root.right)));
    }

    static int HightofTreeBylecel(Node root){
        if(root == null) return 0;
        return 1 + (Math.max(HightofTreeBylecel(root.left),HightofTreeBylecel(root.right)));
    }

    static int hightOfTree(Node root){
        if(root == null || root.left == null && root.right == null) return 0;
        return 1 +  Math.max(hightOfTree(root.left),hightOfTree(root.right));
    }
    static void POSTtraverse(Node root) {
        if (root == null) return;
//        POSTtraverse(root.left);
//        POSTtraverse(root.right);
//        System.out.println(root.val);
//        System.out.println(countTreeNode(root));
//        System.out.println(minNode(root));
        System.out.println(hightOfTree(root));
    }

}
