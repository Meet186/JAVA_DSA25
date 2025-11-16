package HASHMAP;

import java.util.LinkedList;

public class Mymap <K,V>{
   private static final int DEFAULT_CAPACITY = 16;
   private static final float LOAD_FACTOR = 0.75f;
   private LinkedList<Node>[] bucket;
   private int n;
   public class Node {
       K key;
       V value;
       public Node(K key, V value) {
           this.key = key;
           this.value = value;
       }
   }

    public Mymap() {
       initBucket(DEFAULT_CAPACITY);
    }

    private void initBucket(int capacity) {
       bucket = new LinkedList[capacity];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }
    }
    private int getHashCode(K key){
       int code = key.hashCode();
       return Math.abs(code) % bucket.length; // Hasing
    }
    private int serchINBucket(LinkedList<Node> currbucket, K key) {
        for (int i = 0; i < currbucket.size(); i++) {
            if(currbucket.get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    public void put(K key,V value){
       int bi = getHashCode(key);
       LinkedList<Node> currentBucket = bucket[bi];
       int index = serchINBucket(currentBucket,key);
       if(index == -1){ // key not exist in map
           Node node = new Node(key, value);
           currentBucket.add(node);
           n++;
       } else  {
           currentBucket.get(index).value = value;
       }
       if(n > bucket.length * LOAD_FACTOR){ //  THRESHOLD VALUE
           reHash();
       }
    }

    private void reHash() {
       LinkedList<Node>[] oldBucket = bucket;
       initBucket(bucket.length * 2);
       n = 0; // because we again use the put method
       for(var bucket : oldBucket){
           for(var node : bucket){
               put(node.key, node.value);
           }
       }
    }

    public V remove(K key){
        int bi = getHashCode(key);
        LinkedList<Node> currentBucket = bucket[bi];
        int index = serchINBucket(currentBucket,key);
        if(index != -1){ // key exist
            V value = currentBucket.get(index).value;
            currentBucket.remove(index);
            n--;
            return value;
        }
        return null; // Key not exist in map
    }
    public V get(K key){
        int bi = getHashCode(key);
        LinkedList<Node> currentBucket = bucket[bi];
        int index = serchINBucket(currentBucket,key);
        if(index != -1){
            return currentBucket.get(index).value;
        }
        return null;
    }
    public boolean contains(K key){
        int bi = getHashCode(key);
        LinkedList<Node> currentBucket = bucket[bi];
        int index = serchINBucket(currentBucket,key);
        return index != -1 ? true : false;
    }


}
