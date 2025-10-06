package TREE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        selfTree tree = new selfTree();
//        Scanner sc = new Scanner(System.in);
//        tree.populate(sc);
//        tree.printPretier();

         BST2 tree = new BST2();
         tree.insert(2);
         tree.insert(7);
         tree.insert(9);
         tree.insert(4);
         tree.insert(14);
         tree.insert(20);
         tree.display();



    }
}
