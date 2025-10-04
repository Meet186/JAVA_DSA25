package TREE;
import java.util.*;

public class leetcode103 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    static int getLevel( TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getLevel(root.left),getLevel(root.right));
    }
    static void printNthlevel(TreeNode root, int n ,List<Integer> temp){
        if(root == null) return;
        if(n == 1){
            temp.add(root.val);
            return;
        }
        printNthlevel(root.left,n-1,temp);
        printNthlevel(root.right,n-1,temp);
    }
    static void printNthlevel2(TreeNode root, int n,List<Integer> temp ){
        if(root == null) return;
        if(n == 1){
            temp.add(root.val);
            return;
        }
        printNthlevel2(root.right,n-1,temp);
        printNthlevel2(root.left,n-1,temp);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int level = getLevel(root);
        for (int i = 1; i <= level ; i++) {
            List<Integer> temp = new ArrayList<>();
            if(i % 2 != 0){
                printNthlevel(root,i,temp);
            } else {
                printNthlevel2(root,i,temp);
            }
            ans.add(temp);
        }
            return ans;
        }
    }
}
