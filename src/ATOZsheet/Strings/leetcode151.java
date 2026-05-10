package ATOZsheet.Strings;

import java.util.Stack;

public class leetcode151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        Stack<String> stack = new Stack<>();

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {

            ans.append(stack.pop());

            if (!stack.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
