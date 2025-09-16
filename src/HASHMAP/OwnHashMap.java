package HASHMAP;

import java.util.LinkedList;
import java.util.List;

public class OwnHashMap <k,v>{
    private static final int  DEAFULT_CAPACITY = 16;
    private static final float  DEAFULT_LOAD_FACTOR = 0.75f;
    private class Node{
        k key;
        v value;
        Node(k key,v value){
            this.key = key;
            this.value = value;
        }
    }
    private int n; // the number of entries in map
    private LinkedList<Node>[] buckets;

    OwnHashMap(){
        initBucket(DEAFULT_CAPACITY);
    }
    private void initBucket(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public int size(){ // return the number of entries in map
        return n;
    }

    public void put(k key,v value){ // insert and update
        int bi = hashFun(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = serchInBucket(currBucket,key);
        if(ei == -1){ // key does not exist,we have to entre a new node
            Node node = new Node(key,value);
            currBucket.add(node);
            n++;
        } else { // update value
            Node currNode = currBucket.get(ei);
            currNode.value = value;

        }
        if(n >= buckets.length * DEAFULT_LOAD_FACTOR){ // THRESHOLD VALUE
            rehash();

        }
    }

    private void rehash() {
        LinkedList<Node>[] oldBucket = buckets;
        initBucket(oldBucket.length * 2);
        n = 0;
        for(var bucket : oldBucket){
            for (var node : bucket){
                put(node.key, node.value);
            }
        }
    }

    private int serchInBucket(LinkedList<Node> ll, k key) {
        for (int i = 0; i < ll.size(); i++) {
            if(ll.get(i).key == key){
                return i;
            }
        }

        return -1;

    }


    private int hashFun(k key) {
        int hashValue = key.hashCode();
        return Math.abs(hashValue) % buckets.length;
    }

    public v get(k key){ // return value
        int bi = hashFun(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = serchInBucket(currBucket,key);
        if(ei != -1){
            Node currNode = currBucket.get(ei);
            return currNode.value;
        }

        return null;
    }

    public v remove(k key){
        int bi = hashFun(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = serchInBucket(currBucket,key);
        if(ei != -1){
            Node currNode = currBucket.get(ei);
            currBucket.remove(ei);
            n--;
            v value = currNode.value;
            return value ;
        }
        return null;
    }




}
