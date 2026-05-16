package ATOZsheet.Recurssion;

import java.util.Stack;

public class reverseStack {
    public void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st,top);
    }
    private void insertAtBottom(Stack<Integer> st, int el) {
        if(st.isEmpty()){
            st.push(el);
        }
        int top = st.pop();
        insertAtBottom(st,el);
        st.push(top);
    }
}
