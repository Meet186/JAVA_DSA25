package TREE;


public class AVL2 {

    public class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }
    public int getHeight(){
        return height(root);
    }

    public void insert(int val){
        root = insert(val,root);

    }
    private Node insert(int val, Node node) {
        if(node  == null){
            node = new Node(val);
            return node;
        }
        if(val < node.val){
            node.left = insert(val,node.left);
        }
        if(val >= node.val){
            node.right = insert(val,node.right);
        }
        node.height = 1 + Math.max(height(node.left),height(node.right));
        return rotate(node);
    }

    private Node rotate(Node node) {
        int balance = height(node.left) - height(node.right);

        // Right heavy
        if (balance < -1) {
            if (height(node.right.left) > height(node.right.right)) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        // Left heavy
        if (balance > 1) {
            if (height(node.left.right) > height(node.left.left)) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        return node;

    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;

    }


    public void insertMultiple(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public boolean isBalanced(){
        return balanced(root);

    }

    private boolean balanced(Node root) {
        if(root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && balanced(root.left) && balanced(root.right);
    }

    public void display(){
        display(root,"ROOT NODE : ");

    }

    private void display(Node root, String details) {
        if(root == null) return;;
        System.out.println(details + root.val);
        display(root.left,"LEFT CHILD OF : " + root.val + ":");
        display(root.right,"RIGHT CHILD OF : " + root.val + ":");

    }

    public void displayPriter(){
        displaypriter(root,0);
    }

    private void displaypriter(Node root, int level) {
        if(root == null) return;
        displaypriter(root.right,level + 1);
        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + root.val);
        } else {
            System.out.println(root.val);
        }
        displaypriter(root.left,level + 1);
    }


}
