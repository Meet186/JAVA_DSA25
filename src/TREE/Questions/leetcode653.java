package TREE.Questions;

import java.util.HashSet;

public class leetcode653 {
    HashSet<Integer> map = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(map.contains(k- root.val)) return true;
        map.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
