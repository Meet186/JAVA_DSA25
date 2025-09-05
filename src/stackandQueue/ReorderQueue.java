package stackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderQueue {
    static void reorderQueue(Queue<Integer> queue){
        Stack<Integer> st = new Stack<>();
        int size = queue.size()/2;
        for (int i = 0; i < size; i++) {
            st.push(queue.remove());
        }
        // add element to the queue again
        while (!st.isEmpty()){
            queue.add(st.pop());
        }
        for (int i = 0; i < size; i++) {
            st.push(queue.remove());
        }

        for (int i = 0; i < size; i++) {
            queue.add(st.pop());
            queue.add(queue.remove());

        }


        while (!queue.isEmpty()){
            st.push(queue.remove());
        }
        while (!st.isEmpty()){
            queue.add(st.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

    }
}
