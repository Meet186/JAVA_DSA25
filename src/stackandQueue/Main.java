package stackandQueue;

public class Main {
    public static void main(String[] args) {
//        costumQueue queue = new costumQueue(10);
//
//        queue.insert(5);
//        queue.insert(8);
//        queue.insert(7);
//        queue.insert(2);
//        queue.insert(3);
//        queue.display();

        MyQueue queue = new MyQueue();
        queue.push(5);
        queue.push(4);
        queue.push(3);
        queue.push(2);
        queue.push(1);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());

    }
}
