package ATOZsheet.Strings;

public class leetcode1021 {
    public String removeOuterParentheses(String s) {
        int counter = 0;
        String ans = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')') counter--;
            if(counter != 0) ans += s.charAt(i);
            if(s.charAt(i) == '(') counter++;

        }
        return ans;
    }
}
