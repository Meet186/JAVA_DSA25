package TREE.Questions;

import java.util.*;



public class BFSserch {

    public class TreeNode {
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
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                temp.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            double averageoflevel = 0;
            for (int i = 0; i < level; i++) {
                TreeNode currNode = queue.poll();
                averageoflevel += currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            averageoflevel = averageoflevel / level;
            result.add(averageoflevel);
        }
        return result;

    }

    public int findSuccessor(TreeNode root,int key){
        if(root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(currNode.left != null){
                queue.offer(currNode.left);
            }
            if(currNode.right != null){
                queue.offer(currNode.right);
            }
            if(currNode.val == key) return queue.poll().val;
        }

        return -1;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reversed = true;
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int level = queue.size();
            for (int i = 0; i < level ; i++) {
                if(reversed){ // normal
                    TreeNode currNode = queue.pollFirst();
                    temp.add(currNode.val);
                    if(currNode.left != null){
                        queue.addLast(currNode.left);
                    }
                    if(currNode.right != null) {
                        queue.addLast(currNode.right);
                    }
                }else {
                    TreeNode currNode = queue.pollLast();
                    temp.add(currNode.val);
                    if(currNode.right != null) {
                        queue.addFirst(currNode.right);
                    }
                    if(currNode.left != null){
                        queue.addFirst(currNode.left);
                    }

                }

            }
            reversed = !reversed;
            ans.add(temp);
        }

        return ans;

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                temp.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            ans.add(0,temp);
        }
        return ans;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int level = queue.size();

            for(int i=0; i<level; i++){
                TreeNode currNode = queue.poll();
                if(i == level - 1){
                    ans.add(currNode.val);
                }
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }

        }
        return ans;
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);
        return (
                (level(root,x,0) == level(root,y,0) && (!isSibling(root,xx,yy)))
                );
    }
    private int level(TreeNode node, int x, int level) {
        if(node == null) return 0;
        if(node.val == x){
            return level;
        }
        int l =  level(node.left,x,level+1);
        if(l != 0){
            return l;
        }
        return level(node.right,x,level+1);
    }
    private boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy) {
        if(node == null) return false;
        return (
                (node.left == xx && node.right == yy) ||  (node.left == yy && node.right == xx)
                 || (isSibling(node.left,xx,yy)) || (isSibling(node.right,xx,yy))
                );
    }
    private TreeNode findNode(TreeNode node, int x) {
        if(node == null) return null;
        if(node.val == x) return node;
        TreeNode n = findNode(node.left,x);
        if(n != null) {
            return n;
        }
        return  findNode(node.right,x);
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
