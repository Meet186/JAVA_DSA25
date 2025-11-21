package TREE.Questions;
import java.util.*;

public class leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list.get(k-1);
    }
    private void helper(TreeNode root,List<Integer> list){
        if(root == null) return;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }

    private int k;
    private int ans;
    public int kthSmallest2(TreeNode root, int k) {
        this.k = k;
        helper2(root);
        return ans;
    }
    private void helper2(TreeNode root){
        if(root == null) return;
        helper2(root.left);
        k--;
        if(k == 0){
            ans = root.val;
            return;
        }
        helper2(root.right);
    }
}
