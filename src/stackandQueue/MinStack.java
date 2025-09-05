package stackandQueue;
import java.util.*;

public class MinStack {
    private Stack<Integer> st = new Stack<>();
    int min ;
    public MinStack() {

    }

    public void push(int val) {
        if(st.isEmpty()){
            min = val;
        } else{
          min =   st.peek() <= min ? st.peek() : min;
        }
        st.push(val);
    }

    public void pop() {
        if(st.peek() <= min){
            min = st.peek();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
