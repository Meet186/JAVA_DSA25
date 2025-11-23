package TRIE;

public class longestWordprefix {
    static class Node{
        Main.Node[] children;
        boolean endOfWord;
        public Node() {
            children = new Main.Node[26]; // a to z
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            endOfWord = false;
        }
    }
    static Main.Node root = new Main.Node();
    public void insert(String word){
        Main.Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new Main.Node();
            }
            if(i == word.length()-1){
                curr.children[index].endOfWord = true;
            }
            curr = curr.children[index];
        }
    }
    public boolean serch(String word) {
        Main.Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            if (i == word.length() - 1 && curr.children[index].endOfWord == false) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    public static String ans = "";
    public static void longestWord(Node root,StringBuilder temp){
        if(root == null) return;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].endOfWord == true) {
                temp.append((char) i + 'a');
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        longestWordprefix obj = new longestWordprefix();
        String words[] = {"a","banana","apple","ap","apply","apple"};
        for (int i = 0; i < words.length; i++) {
            obj.insert(words[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
}
