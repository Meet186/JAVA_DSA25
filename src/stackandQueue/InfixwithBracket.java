package stackandQueue;
import java.util.Stack;
public class InfixwithBracket {
    static int infixExpressionWithBracket(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascai = (int) ch;
            if(ascai >= 48 && ascai <= 57) val.push(ascai-48);
            else if (op.isEmpty() || ch == '(' || op.peek() == '(') op.push(ch);
            else if (ch == ')'){
                while (op.peek() != '('){
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1+v2);
                    if(op.peek() == '-') val.push(v1-v2);
                    if(op.peek() == '*') val.push(v1*v2);
                    if(op.peek() == '/') val.push(v1/v2);
                    op.pop();
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-') { // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1+v2);
                    if(op.peek() == '-') val.push(v1-v2);
                    if(op.peek() == '*') val.push(v1*v2);
                    if(op.peek() == '/') val.push(v1/v2);
                    op.pop();
                    op.push(ch);
                } if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if(op.peek() == '*') val.push(v1*v2);
                        if(op.peek() == '/') val.push(v1/v2);
                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
            }
        }
        while (val.size() > 1){
            int v2 = val.pop();
            int v1 = val.pop();
            if(op.peek() == '+') val.push(v1+v2);
            if(op.peek() == '-') val.push(v1-v2);
            if(op.peek() == '*') val.push(v1*v2);
            if(op.peek() == '/') val.push(v1/v2);
            op.pop();
        }
        return val.peek();
    }
    public static void main(String[] args) {
        String str = "9+(5+3)*3+2/2"; // 34
        System.out.println(infixExpressionWithBracket(str));
    }
}
