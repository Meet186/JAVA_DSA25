package TREE;

public class BST {

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int hight;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;

        }
    }
     private Node root;

    public void create_ROOT(int value){
        root = new Node(value);
        root.hight = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
    public BST() {

    }

    private int getHeight(Node node){
        if(node == null) return -1;
        return node.hight;
    }

    public int getHeight(){
        return getHeight(root);
    }

    public void insert(int value){
       root =  insert(value,root);
    }
    private Node insert(int value, Node node) {
        if(node == null) {
           node = new Node(value);
            return node;
        }
        if(value <= node.value){
            node.left = insert(value,node.left);
        }
        if(value > node.value){
            node.right = insert(value,node.right);
        }
        node.hight = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        return node;
    }



    public void insertMultiple(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void display(){
        display(root,0);
    }

    private void display(Node root, int level) {
        if(root == null) return;
        display(root.right,level + 1);
        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>" + root.value);
        } else {
            System.out.println(root.value);
        }
        display(root.left,level + 1);


    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node root) {
        if(root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


}
