package HASHMAP;

import java.util.*;

public class OWNMAP<k, v> {
    private static final int DEAFULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<Node>[] bucket;
    private int n = 0; // for size

    private class Node { // private class that has a key value pair
        k key;
        v value;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    OWNMAP() {
        initBucket(DEAFULT_CAPACITY);

    }

    private void initBucket(int deafultCapacity) { // create a bucket Array that consist a LINKLIST at each index
        bucket = new LinkedList[deafultCapacity];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    private int getHashValue(k key) {
        int hashcode = key.hashCode();
        return Math.abs(hashcode) % bucket.length; // this is because the hashcode must be lies in bucket range
    }

    private int serchInBucket(LinkedList<Node> currBucket, k key) {
        for (int i = 0; i < currBucket.size(); i++) {
            if (currBucket.get(i).key == key) {
                return i; // Key alredy exist at this index
            }

        }
        return -1; // No key present in map
    }

    private void rehash() { // MAKE SURE THAT put,get,remove,size work at O(1)
        // IF THRESHHOLD VALUE IS > THAN LOAD FACTOR THEN REHASH
        LinkedList<Node>[] oldBucket = bucket;
        initBucket(oldBucket.length * 2);
        n = 0;
        for (var bucket : oldBucket) {
            for (var node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    // PUT
    public void put(k key, v value) {
        int bi = getHashValue(key);
        LinkedList<Node> currBucket = bucket[bi];
        int index = serchInBucket(currBucket, key);
        if (index == -1) { // Mean we need to create a new node and add in map
            Node newNode = new Node(key, value);
            currBucket.add(newNode);
            n++;
        } else {
            currBucket.get(index).value = value;
        }
        if (n >= bucket.length * LOAD_FACTOR) {
            rehash();
        }
    }


    // GET
    public v get(k key) {
        int bi = getHashValue(key);
        LinkedList<Node> currBucket = bucket[bi];
        int index = serchInBucket(currBucket, key);
        if (index != -1) { // Mean value exist in map
            return currBucket.get(index).value;
        }
        return null;
    }
    // REMOVE

    public v remove(k key) {
        int bi = getHashValue(key);
        LinkedList<Node> currBucket = bucket[bi];
        int index = serchInBucket(currBucket, key);
        if (index != -1) { // Mean value exist in map
            v value = currBucket.get(index).value;
            n--;
            currBucket.remove(index);
            return value;
        }
        return null;
    }

    // CONATINS KEY

    public boolean contains(k key) {
        int bi = getHashValue(key);
        LinkedList<Node> currBucket = bucket[bi];
        int index = serchInBucket(currBucket, key);
        if (index != -1) { // Mean value exist in map
            return true;
        }
        return false;
    }


    // DISPLAY (bucket-wise)
    public void display() {
        System.out.println("OWNMAP contents:");
        for (int i = 0; i < bucket.length; i++) {
            LinkedList<Node> currBucket = bucket[i];
            if (!currBucket.isEmpty()) {
                System.out.print("Bucket " + i + " -> ");
                for (Node node : currBucket) {
                    System.out.print("{" + node.key + "=" + node.value + "} ");
                }
                System.out.println();
            }
        }
    }

    // display key value
    public void displayKey_Value(){
        for (int i = 0; i < bucket.length; i++) {
            LinkedList<Node> currBucket = bucket[i];
            if(!currBucket.isEmpty()){
                for(var node : currBucket){
                    System.out.print("{" + node.key + "=" + node.value + "}");
                }
            }
        }
    }


    // SIZE
    public int size() {
        return n;
    }

    // GET CAPACITY
    public int getDeafultCapacity() {
        return DEAFULT_CAPACITY;
    }

    // GET LOAD FACTOR
    public float getLoadFactor() {
        return (float) (n * (1.0) / bucket.length);
    }


}
