package stackandQueue;

import java.util.*;

public class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    public MyQueue() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int val = helper.pop();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return val;
    }

    public int peek() {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int val = helper.peek();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return val;
    }

    public boolean empty() {
        return stack.empty();
    }
}
