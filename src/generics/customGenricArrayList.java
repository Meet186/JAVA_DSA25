package generics;

import java.util.Arrays;

public class customGenricArrayList <T> {
    private Object[] data;
    private static int DEFAULY_SIZE = 10;
    private int size = 0;

    public customGenricArrayList() {
        this.data = new Object[DEFAULY_SIZE];
    }

    // PRIVATE<METHODS>
    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object temp[] = new Object[data.length * 2];
        // copy the element
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    // PUBLIC <METHODS>
    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public T remove() {
        T removed = (T) (data[--size]) ;
        return removed;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int val) {
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
        customGenricArrayList list = new customGenricArrayList();
        list.add(5);
        list.add("meet");
        System.out.println(list);
    }


}
