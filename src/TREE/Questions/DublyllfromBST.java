package TREE.Questions;

public class DublyllfromBST {


    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    Node head;
    Node tail;
    public Node convertTree(TreeNode root){
        if(root == null) return null;
        helper(root);
        return head;
    }

    private void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);
        Node newNode = new Node(node.val);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        helper(node.right);
    }
    public static void main(String[] args) {

    }
}
