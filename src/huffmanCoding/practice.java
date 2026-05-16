package huffmanCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class practice {
    private HashMap<Character,String> incoder ;
    private HashMap<String,Character> decoder ;
    private class Node implements Comparable<Node> {
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


    practice (String feeder){
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for (int i = 0; i < feeder.length() ; i++) {
            freqMap.put(feeder.charAt(i),freqMap.getOrDefault(feeder.charAt(i),0) + 1);
        }
        // make a node of every key in freqMap
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()){
            heap.add(new Node(entry.getKey(),entry.getValue()));
        }
        while (heap.size() > 1){
            Node first = heap.remove();
            Node second = heap.remove();
            Node newNode = new Node('\0',first.cost+second.cost);
            newNode.left = first;
            newNode.right = second;
        }
        Node root = heap.remove();
        this.incoder = new HashMap<>();
        this.decoder = new HashMap<>();
        this.fillEncoderDecoder(root,"");
    }

    private void fillEncoderDecoder(Node root,String osf) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            this.incoder.put(root.data,osf);
            this.decoder.put(osf,root.data);
        }
        fillEncoderDecoder(root.left, osf+"0");
        fillEncoderDecoder(root.right, osf+"1");
    }
    public String Incoding(String str){
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            ans += incoder.get(str.charAt(i));
        }
        return ans;
    }

    public String Decoding(String incoded){
        String ans = "";
        String key = "";
        for (int i = 0; i < incoded.length(); i++) {
           key += incoded.charAt(i);
           if(decoder.containsKey(key)){
               ans += decoder.get(key);
               key = "";
           }
        }
        return ans;
    }
}
