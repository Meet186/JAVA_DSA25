package stackandQueue;
import java.util.*;
public class questions {

    // find nextSmaller element.
    static int[] nextSmallerElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]){
                 st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int[] ans = nextSmallerElement(arr);
        System.out.println(Arrays.toString(ans));

    }
}
