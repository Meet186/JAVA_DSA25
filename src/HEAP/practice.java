package HEAP;

import java.util.ArrayList;

public class practice <T extends Comparable<T>>  {
    private ArrayList<T> list ;
    practice(){
        list = new ArrayList<>();
    }
    private void swap(int i,int j){
        T temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    private int getParent(int index){
        return (index-1/2);
    }
    private int getleft(int index){
        return (index * 2 + 1);
    }
    private int getright(int index){
        return (index * 2 + 2);
    }
    private void upHeap(int index){
        if(index == 0) return;
        int parent = getParent(index);
        if(list.get(index).compareTo(list.get(parent)) > 0){
            swap(index,parent);
            upHeap(parent);
        }
    }

    private void downHeap(int index){
        int max = index;
        int left = getleft(index);
        int right = getright(index);

        // find which side the max element exist
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



    // PUBLIC METHODS
    public void insert(T val){
        list.add(val);
        upHeap(list.size()-1);

    }



    public T remove() throws Exception{
        if(list.size() == 0) throw new Exception("Heap is empty");
        T top = list.get(0);
        T last = list.get(list.size()-1);
        list.set(0,last);
        list.remove(list.size()-1);

        if(!list.isEmpty()) {
            downHeap(0);
        }
        return top;
    }

}
