package TRIE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static class Node extends longestWordprefix.Node {
        Node[] children;
        boolean endOfWord;
        public Node() {
            children = new Node[26]; // a to z
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            endOfWord = false;
        }
    }
    static Node root = new Node();
    public void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            if(i == word.length()-1){
                curr.children[index].endOfWord = true;
            }
            curr = curr.children[index];
        }
    }
    public boolean serch(String word) {
        Node curr = root;
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
    public  boolean wordBreak(String key){
        if(key.length() == 0) return true;
        for (int i = 1; i <= key.length(); i++) {
            String first = key.substring(0,i);
            String second = key.substring(i);
            if(serch(first) && wordBreak(second)){
                return true;
            }

        }
        return false;
    }
    // find word prefix is exist or not
    public boolean isPrefixExist(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }


    public static void main(String[] args) {
        Main obj = new Main();
//         String[] words = {"i","like","sam","samsung","mobile"};
//         String key = "sam";
//         for(var el : words){
//             obj.insert(el);
//         }
//        System.out.println(obj.isPrefixExist(key));

        String str = "ababa";

    }
}
