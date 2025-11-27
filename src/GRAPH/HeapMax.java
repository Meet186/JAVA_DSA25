package GRAPH;

import java.util.ArrayList;

public class HeapMax <T extends Comparable<T>>{
    ArrayList<T> list;

    public HeapMax() {
        this.list = new ArrayList<>();
    }

    public void insert(T val){
        list.add(val);
        upHeap(parent(list.size()-1));
    }

    public T remove(){
        if(list.size() == 0) {
            System.out.println("Remove from Empty Heap !");
            return null;
        }
        T temp = list.get(0);
        T last = list.get(list.size()-1);

        list.set(0,last);
        list.remove(list.size()-1);
        if(!list.isEmpty()){
            downHeap(0);
        }
        return temp;
    }


    // private methods
    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return index * 2 + 1;
    }
    private int right(int index){
        return index * 2 + 2;
    }
    private void swap(int first,int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second,temp);
    }
    private void upHeap(int index){
        if(index == 0) return;
        int parent = parent(index);
        if(list.get(index).compareTo(list.get(parent)) > 0){
            swap(index,parent);
            upHeap(parent);
        }
    }
    private void downHeap(int index) {
        int max = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(left).compareTo(list.get(index)) > 0){
            max = left;
        }
        if(right < list.size() && list.get(right).compareTo(list.get(index)) > 0){
            max = right;
        }
        if(max != index){
            swap(max,index);
            downHeap(max);
        }
    }


}
