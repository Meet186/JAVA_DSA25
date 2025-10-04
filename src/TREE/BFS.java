package TREE;

public class BFS { // BFS - BREATH FIRST SERCH -> level order traversel
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static int getLevel(Node root){
        if(root == null) return 0;
        return 1 + Math.max(getLevel(root.left),getLevel(root.right));
    }
    static void printNthlevel(Node root, int n ){
        if(root == null) return;
        if(n == 1){
            System.out.print(root.val + "-");
            return;
        }
        printNthlevel(root.left,n-1);
        printNthlevel(root.right,n-1);
    }
    static void BSFPrint(Node root){
       int level = getLevel(root);
        for (int i = 1  ; i <= level ; i++) { // TC _ O(N)
            printNthlevel(root,i);
            System.out.println();
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

//        System.out.println(getLevel(root));
        BSFPrint(root);
    }

}
