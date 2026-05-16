package ATOZsheet.Recurssion;
import java.util.Stack;
public class sortStack {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        sortStack(st);
        insertAtCorrectPosition(st,top);
    }
    private void insertAtCorrectPosition(Stack<Integer> st, int top) {
        if(st.isEmpty() || st.peek() <= top){
            st.push(top);
            return;
        }
        int el = st.pop();
        insertAtCorrectPosition(st,top);
        st.push(el);
    }
}
