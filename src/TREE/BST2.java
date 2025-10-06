package TREE;

import static javax.swing.Spring.height;

public class BST2 {

    public class Node {
        private int value;
        private int hight;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public BST2() {
    }

    private int getHight(Node node){
        if(node == null) return -1;
        return node.hight;
    }

    public void create_ROOT(int value){
        root = new Node(value);
    }

    public void insert(int value){
        insert(root,value);
    }

    private Node insert(Node node, int value) {
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value <= node.value){
            node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        node.hight = Math.abs(getHight(node.left)-getHight(node.right)) + 1;
        return node;
    }

    public void display(){
        display(root,0);
    }

    private void display(Node root, int level) {
        if(root == null) return;
        display(root.right,level+1);

        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + root.value);
        } else {
            System.out.println(root.value);
        }
        display(root.left,level+1);
    }


}
