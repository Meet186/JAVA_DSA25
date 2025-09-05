package stackandQueue;
import java.util.*;
public class PrefixToinfix {
    static String prefixToinfixConvert(String str){
        Stack<String> val = new Stack<>();
        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            int ascai = (int) ch;
            if(ascai >= 48 && ascai <= 57){
                val.push(""+ch);
            } else {
                String v1 = val.pop();
                String v2 = val.pop();
                val.push(v2+v1+ch);
            }
        }

        return val.peek();
    }
    // postFix to prefix
    static  String postFixToPrefix(String str) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascai = (int) ch;
            if (ascai >= 48 && ascai <= 57) {
                // 0 to 9
                st.push("" + ch);
            } else {
                String val2 = st.pop();
                String val1 = st.pop();
                String newString = ch + val1 + val2;
                st.push(newString);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {

    }
}
