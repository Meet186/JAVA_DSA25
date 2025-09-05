package stackandQueue;
import java.util.*;
public class InfixExpression {
    static int infixExpression(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascai = (int) ch;
            if(ascai >= 48 && ascai <= 57) val.push(ascai-48); // 0-9
            else if (op.size() == 0) op.push(ch); // +-*/
            else {
                if(ch == '+' || ch == '-'){
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1+v2);
                    if(op.peek() == '-') val.push(v1-v2);
                    if(op.peek() == '*') val.push(v1*v2);
                    if(op.peek() == '/') val.push(v1/v2);
                    op.pop();
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '+' || op.peek() == '-'){
                        op.push(ch);
                    } else {
                        // op ->  * /
                        int v2 = val.pop();
                        int v1 = val.pop();

                        if(op.peek() == '*') val.push(v1*v2);
                        if(op.peek() == '/') val.push(v1/v2);
                        op.pop();
                        op.push(ch);

                    }
                }
            }
        }
        while (val.size() > 1){
            int val2 = val.pop();
            int val1 = val.pop();
            if(op.peek() == '+') val.push(val1+val2);
            if(op.peek() == '-') val.push(val1-val2);
            if(op.peek() == '*') val.push(val1*val2);
            if(op.peek() == '/') val.push(val1/val2);
            op.pop();

        }
        return val.peek();
    }
    public static void main(String[] args) {
        String str = "9-4+3*4/6";
        System.out.println(infixExpression(str));
    }
}
