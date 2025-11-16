package HEAP;

import java.util.ArrayList;

public class MaxHeap < T extends Comparable<T>>{
    private ArrayList<T> list;
    MaxHeap(){
        list = new ArrayList<>();
    }
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
    public void insert(T val){
        list.add(val);
        upHeap(list.size()-1);
    }
    private void upHeap(int index){
        if(index == 0) return;
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) > 0 ){
            swap(index,p);
            upHeap(p);
        }
    }

    public T remove() throws Exception{
        if(list.size() == 0){
            throw new Exception("Heap is empty");
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
    private void downHeap(int index){
       int max = index;
       int left = left(index);
       int right = right(index);

       if(left < list.size() && list.get(max).compareTo(list.get(left)) < 0){
           max = left;
       }
       if(right < list.size() && list.get(max).compareTo(list.get(right)) < 0){
            max = right;
        }
        if(max != index){
            swap(max,index);
            downHeap(max);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        if(list.isEmpty()) {
            throw new  Exception("list is empty");
        }
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()){
            data.add(this.remove());
        }
        return data;

    }

    public static void main(String[] args) throws Exception {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(5);
        maxHeap.insert(50);
        maxHeap.insert(15);
        maxHeap.insert(58);
        maxHeap.insert(53);

        ArrayList<Integer> list = maxHeap.heapSort();
        System.out.println(list);

    }
}
