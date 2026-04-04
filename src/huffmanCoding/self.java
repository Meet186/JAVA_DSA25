package huffmanCoding;

import java.util.HashMap;

public class self {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;


    public class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    self(String str) throws Exception {
        HashMap<Character,Integer> keyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(keyMap.containsKey(ch)){
                int ov = keyMap.get(ch);
                ov += 1;
                keyMap.put(ch,ov);
            } else {
                keyMap.put(ch,1);
            }
        }
        Heap<Node> minHeap = new Heap<>();
        for(var entry : keyMap.entrySet()){
            Node newNode = new Node(entry.getKey(),entry.getValue());
            minHeap.insert(newNode);
        }

        while (minHeap.size() != 1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;
            minHeap.insert(newNode);
        }
        // take root of tree
       Node root =  minHeap.remove();
       this.encoder = new HashMap<>();
       this.decoder = new HashMap<>();
       this.fillEncoderDecoder(root,"");

    }

    private void fillEncoderDecoder(Node root, String osf) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            this.encoder.put(root.data,osf);
            this.decoder.put(osf,root.data);
        }
        fillEncoderDecoder(root.left,osf + "0");
        fillEncoderDecoder(root.right,osf + "1");
    }

    public String Encoder(String source){
        int n = source.length();
        System.out.println("bits use before Encoded : " + n * 2 * 8);
        String ans = "";
        for (int i = 0; i < source.length(); i++) {
            ans += encoder.get(source.charAt(i));
        }
        System.out.println("bits use After Encoded : " + ans.length());
        return ans;
    }
    public String Decoder(String EncodedStr){
        String key = "";
        String ans = "";
        for (int i = 0; i < EncodedStr.length(); i++) {
            key += EncodedStr.charAt(i);
            if(decoder.containsKey(key)){
                ans += decoder.get(key);
                key = "";
            }
        }
        return ans;
    }
}
