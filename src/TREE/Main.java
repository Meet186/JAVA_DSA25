package TREE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        selfTree tree = new selfTree();
//        Scanner sc = new Scanner(System.in);
//        tree.populate(sc);
//        tree.printPretier();

//         BST2 tree = new BST2();
//         tree.insert(2);
//         tree.insert(7);
//         tree.insert(9);
//         tree.insert(4);
//         tree.insert(14);
//         tree.insert(20);
//         tree.display();

//        BST tree = new BST();
//        tree.create_ROOT(5);
//        int nums [] = {21,4,5,7,8,3,1,2};
//        tree.insertMultiple(nums);
//        tree.display();;

//        AVL tree = new AVL();
//
//        for (int i = 0; i < 10; i++) {
//            tree.insert(i);
//        }
//
//        tree.displaypriter();
//        System.out.println(tree.height());

        AVL2 tree = new AVL2();
        AVL tree2 = new AVL();

        int arr [] = {4,5,7,7,8,1,2};
//        tree.insertMultiple(arr);
//        tree.display();;
//         tree.displayPriter();
//        System.out.println(tree.isBalanced());
//        System.out.println(tree.getHeight());

         segmentree tree3 = new segmentree(arr);
         tree3.display();
//           tree3.displayTree();
    }
}
