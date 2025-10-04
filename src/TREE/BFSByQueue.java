package TREE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSByQueue {

    static  class Node {
        int val;
        Node left;
        Node right;
        // Constructor
        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while (!q.isEmpty()){
            Node temp = q.peek();
           if(temp.left != null) q.add(temp.left);
           if(temp.right != null) q.add(temp.right);
           System.out.print(temp.val + " ");
           q.remove();
        }
    }
   static List<Integer> ans = new ArrayList<>();
    static List<Integer> rightTree(Node root){

            if(root.right == null) return ans ;
            ans.add(root.right.val);
            rightTree(root.right);

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
//        BFS(root);
        System.out.println(rightTree(root));
    }

}
