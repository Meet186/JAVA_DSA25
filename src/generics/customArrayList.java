package generics;

import java.util.Arrays;

public class customArrayList {
    private int[] data;
    private static int DEFAULY_SIZE = 10;
    private int size = 0;

    public customArrayList() {
        this.data = new int[DEFAULY_SIZE];
    }
    // PRIVATE<METHODS>
    private boolean isFull(){
        return size == data.length;
    }
    private void resize() {
        int temp[] = new int[data.length * 2];
        // copy the element
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    // PUBLIC <METHODS>
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }
    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index,int val){
        data[index] = val;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("customArrayList{");
        sb.append("data=").append(Arrays.toString(data));
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        customArrayList list = new customArrayList();
        list.add(5);
        list.add(3);
        list.add(7);
        System.out.println(list);
    }
}
