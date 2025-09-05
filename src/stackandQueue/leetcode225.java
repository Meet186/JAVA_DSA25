package stackandQueue;
import java.util.*;
public class leetcode225 {
    static class MyStack {

       private Queue<Integer> q1 = new LinkedList<>();
       private Queue<Integer> q2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            if(q1.isEmpty()) return -1;
            while(q1.size() > 1){
                q2.add(q1.remove());
            }
            int remove = q1.remove();
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
            return remove;
        }

        public int top() {
            if(q1.isEmpty()) return -1;
            while(q1.size() > 1){
                q2.add(q1.remove());
            }
            int top = q1.peek();
            q2.add(q1.remove());
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
            return top;

        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.empty());

    }
}
