package TREE;

import com.sun.source.tree.Tree;

import java.util.Scanner;


public class selfTree {

    private class TreeNode {
        int value ;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    private TreeNode root;
    public void populate(Scanner sc){
        // FOR ROOT
        System.out.println("Enter the root value : ");
        int value = sc.nextInt();
        root = new TreeNode(value);
        populate(sc,root);
    }

    private void populate(Scanner sc, TreeNode node) {
        // Left Node
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.value);
            int value = sc.nextInt();
            node.left = new TreeNode(value);
            populate(sc,node.left);
        }
        // right Node
        System.out.println("Do you want to enter right of " + node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the rigth of " + node.value);
            int value = sc.nextInt();
            node.right = new TreeNode(value);
            populate(sc,node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(TreeNode root , String indent){
        if(root == null) return;
        System.out.println(indent + root.value);
        display(root.left,indent + "\t");
        display(root.right,indent + "\t");

    }

    public void levelOrderDisplay(){
        int level = getLevel(root);
        for (int i = 1; i <= level ; i++) {
            printnthLevel(root,i);

        }
    }

    private int getLevel(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getLevel(root.left),getLevel(root.right));
    }

    private void printnthLevel(TreeNode root ,int n){
        if(root == null){
            return;
        }
        if(n == 1){
            System.out.print(root.value + "");
        }
        printnthLevel(root.left,n-1);
        printnthLevel(root.right,n-1);
    }

    public void printPretier(){
        printPretier(root,0);
    }

    private void printPretier(TreeNode root, int level) {
        if(root == null) return;
        printPretier(root.right,level+1);
        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---->" + root.value);
        } else {
            System.out.println(root.value);
        }
        printPretier(root.left,level+1);

    }
}
