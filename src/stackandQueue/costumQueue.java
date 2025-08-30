package stackandQueue;

public class costumQueue {
    private int[] data;
    private static final int DEAFULT_SIZE = 10;
    private int end = 0;

    public costumQueue(int size) {
        this.data = new int[size];
    }

    public costumQueue() {
        this(DEAFULT_SIZE);
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];
        // shift the element to left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            if (i != end - 1) {
                System.out.print(data[i] + ",");
            } else {
                System.out.print(data[i]);
            }

        }
        System.out.println();
    }


}
