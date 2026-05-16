package HASHMAP;

import java.util.LinkedList;

public class testMap<k,v> {
    private static final int  DEAFULT_CAPACITY = 16;
    private static final float  LOAD_FACTOR = 0.75f;
    private int n ;
    private LinkedList<Node>[] bucket;
    private class Node {
        k key;
        v value;
        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    testMap(){
        initBucket(DEAFULT_CAPACITY);
    }

    private void initBucket(int deafultCapacity) {
        bucket = new LinkedList[DEAFULT_CAPACITY];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    private int getHashCode(k key){
        int code = key.hashCode();
        return Math.abs(code) % bucket.length; // range of bucket
    }

    private int searchInBucket(LinkedList<Node> currentBucket, k key) {
        for (int i = 0; i < currentBucket.size(); i++) {
            if(currentBucket.get(i).key == key){
                return i;
            }
        }
        return -1;
    }
    private void rehash(){
        LinkedList<Node>[] oldbucket = bucket;
        initBucket(oldbucket.length * 2);
        for(var list : oldbucket){
            for(var node : list){
                put(node.key,node.value);
            }
        }
    }

    public void put(k key,v value){
        int bi = getHashCode(key);
        LinkedList<Node> currentBucket = bucket[bi];
        int idx = searchInBucket(currentBucket,key);
        if(idx != -1){ // already key exist in map
            currentBucket.get(idx).value = value;
        } else {
            Node newNode = new Node(key, value);
            currentBucket.add(newNode);
            n++;
        }

        if(n >= bucket.length * LOAD_FACTOR){
            rehash();
        }
    }

    public v get(k key){
        int bi = getHashCode(key);
        v val;
        LinkedList<Node> currentBucket = bucket[bi];
        int idx = searchInBucket(currentBucket,key);
        if(idx != -1){ // already key exist in map
            val = currentBucket.get(idx).value;
        } else {
           return null;
        }
        return val;
    }

    public v remove(k key){
        int bi = getHashCode(key);
        v val;
        LinkedList<Node> currentBucket = bucket[bi];
        int idx = searchInBucket(currentBucket,key);
        if(idx != -1){ // already key exist in map
            val = currentBucket.get(idx).value;
            currentBucket.remove(idx);
            n--;
        } else {
            return null;
        }
        return val;
    }



}
