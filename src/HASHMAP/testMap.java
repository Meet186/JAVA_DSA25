package HASHMAP;

import java.util.LinkedList;

public class testMap<k,v> {
    private static final int  DEAFULT_CAPACITY = 16;
    private static final float  LOAD_FACTOR = 0.75f;
    private int n ;

    private class Node{
        k key;
        v value;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Node> [] Bucket ;

    testMap(){
        initBucket(DEAFULT_CAPACITY);
    }

    private void initBucket(int deafultCapacity) {
        Bucket = new LinkedList[DEAFULT_CAPACITY];
        for (int i = 0; i < Bucket.length; i++) {
            Bucket[i] = new LinkedList<>();
        }
    }

    public void put(k key, v value){
        int bi = getHashFun(key);
        LinkedList<Node> currentBucket = Bucket[bi];
        int index = serchInBucket(currentBucket,key);
        if(index != -1){ //  Already exist in map
            Node currentNode = currentBucket.get(index);
            currentNode.value = value; // Update the value
        } else {
            Node newNode = new Node(key, value);
            currentBucket.add(newNode);
            n++;
        }

        if(n >= Bucket.length * LOAD_FACTOR){
            rehash();
        }

    }

    private void rehash() {
        LinkedList<Node> [] oldBucket = Bucket;
        initBucket(oldBucket.length * 2);
        n = 0;
        for(var bucket : oldBucket){
            for(var node : bucket){
                put(node.key,node.value);
            }
        }
    }

    public v get(k key){
        int bi = getHashFun(key);
        LinkedList<Node> currentBucket = Bucket[bi];
        int index = serchInBucket(currentBucket,key);
        if(index != -1){
          return currentBucket.get(index).value;
        } else {
            return null;

        }
    }

    public v remove(k key){
        int bi = getHashFun(key);
        LinkedList<Node> currentBucket = Bucket[bi];
        int index = serchInBucket(currentBucket,key);
        if(index != -1){
            v val = currentBucket.get(index).value;
            currentBucket.remove(index);
            n--;
        }
        return null;
    }

    private int serchInBucket(LinkedList<Node> currentBucket,k key) {
        for (int i = 0; i < currentBucket.size(); i++) {
            if(currentBucket.get(i) == key){
                return i;
            }
        }
        return -1;

    }

    private int getHashFun(k key) {
        int value = key.hashCode();
        return Math.abs(value) % Bucket.length;
    }

}
