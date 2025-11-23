package TRIE;

public class uniqueSubStr {
    static class Node {
        Node[] children;
        boolean lastWord;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.lastWord = false;
        }

    }
        static Node root = new Node();
        public  void insert(String word){
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(curr.children[index] == null){ // the character not exist int the trie
                    curr.children[index] = new Node();
                    if(i == word.length()-1){ // each word end hear
                        curr.children[index].lastWord = true;
                    }
                }
                curr = curr.children[index];
            }
        }

        public static boolean search(String key){
            Node curr = root;
            for (int i = 0; i < key.length(); i++){
                int index = key.charAt(i)-'a';
                if(curr.children[index] == null) return false;
                if(i == key.length()-1 && curr.children[index].lastWord == false) return false;
                curr = curr.children[index];
            }
            return true;
        }


        // count unique substring
        public  int countUniqueSubStr(Node root){
            if(root == null) return 0;
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if(root.children[i] != null){
                    count += countUniqueSubStr(root.children[i]);
                }
            }
            return count + 1;
        }

    public static void main(String[] args) {
        uniqueSubStr obj = new uniqueSubStr();
               String str = "ababa";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            obj.insert(suffix);
        }
        System.out.println(obj.countUniqueSubStr(root));
    }
}
