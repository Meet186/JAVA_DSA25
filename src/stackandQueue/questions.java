package stackandQueue;

import java.util.*;

public class questions {

    // find nextSmaller element.
    static int[] nextSmallerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    //https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (ch == ')') {
                    if (st.isEmpty() || st.pop() != '(') return false;
                }
                if (ch == ']') {
                    if (st.isEmpty() || st.pop() != '[') return false;
                }
                if (ch == '}') {
                    if (st.isEmpty() || st.pop() != '{') return false;
                }
            }
        }
        return st.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(')');
            } else if (ch == '[') {
                st.push(']');
            } else if (ch == '{') {
                st.push(']');
            } else if (st.isEmpty() || st.peek() != ch) {
                return false;
            } else {
                st.pop();
            }
        }
        return st.isEmpty();
    }

    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else {
                st.push(ch);
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
        String str = "([)]";


    }
}
