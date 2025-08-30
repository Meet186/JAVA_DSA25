package stackandQueue;

import java.util.*;

public class inBulitExamples {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(35);
//        stack.push(45);
//        stack.push(50);
//        stack.push(55);
//        stack.push(60);
//
//        System.out.println(stack.pop());

//        Queue<Integer> queue = new LinkedList<>();
         // queue is an Interface
//        queue.add(4);
//        queue.add(5);
//        queue.add(42);
//        queue.add(43);
//        queue.add(47);
//
//        System.out.println(queue.poll());; // remove first element
//        System.out.println(queue.remove()); // remove first element
//        System.out.println(queue);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(5);
        deque.addLast(8);
        int[] arr = {1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(53);
        list.add(52);
        list.add(55);

        deque.addAll(list);


    }
}
