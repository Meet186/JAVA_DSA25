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
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
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

    //https://leetcode.com/problems/check-balanced-string/submissions/1756014508/
    public static boolean isBalanced(String num) {
        int odd = 0;
        int even = 0;
        for (int i = 1; i <= num.length() - 1; i++) {
            char ch = num.charAt(i);
            if (i % 2 == 0) {
                odd += (int) ch;
            } else {
                even += (int) ch;
            }
        }

        return odd == even;
    }

    static boolean isBalancedString(String str) { // ((())) || (()))(
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                st.pop();
            }
        }
        return st.isEmpty();
    }

    static int isBalancedString2(String str) { // ((())) || (()))(
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else { // ')'
                st2.push(ch);
            }
        }
        return Math.abs(st2.size() - st.size());
    }

    static int[] removeConsecutiveSubsequence(int[] arr) {
        // Input - {1,2,2,3,10,10,10,4,4,4,5,7,7};
        // Output - {1,3,5};
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty() || arr[i] != st.peek()) {
                st.push(arr[i]);
            } else {
                if (arr[i] == st.peek()) {
                    if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
                        st.pop();
                    } else {
                        continue;
                    }
                }
            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }

    static int[] nextSpan(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            } else {
                ans[i] = st.isEmpty() ? 1 : i - st.peek();
                st.push(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {100,80,60,70,60,75,85};
        int[] ans = nextSpan(arr);
        System.out.println(Arrays.toString(ans));

    }
}
