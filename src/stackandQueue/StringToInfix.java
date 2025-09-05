package stackandQueue;

import java.util.Stack;

public class StringToInfix {
    public static String convert(String str){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascai = (int) ch;
            if(ascai >= 48 && ascai <= 57) val.push(""+ ch);
            else if (op.isEmpty() ||  ch == '(' || op.peek() == '(' ) op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '('){
                    String val1 = val.pop();
                    String val2 = val.pop();
                    if(op.peek() == '+') val.push('+' + val2 + val1);
                    if(op.peek() == '-') val.push('-' + val2 + val1);
                    if(op.peek() == '*') val.push('*' + val2 + val1);
                    if(op.peek() == '/') val.push('/' + val2 + val1);
                    op.pop();
                }
                op.pop();
            } else {
                if(ch == '+' || ch == '-'){
                    String val1 = val.pop();
                    String val2 = val.pop();
                    if(op.peek() == '+') val.push('+' + val2 + val1);
                    if(op.peek() == '-') val.push('-' + val2 + val1);
                    if(op.peek() == '*') val.push('*' + val2 + val1);
                    if(op.peek() == '/') val.push('/' + val2 + val1);
                    op.pop();
                    op.push(ch);
                } if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        String val1 = val.pop();
                        String val2 = val.pop();

                        if(op.peek() == '*') val.push('*' + val2 + val1);
                        if(op.peek() == '/') val.push('/' + val2 + val1);
                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
            }

        }
        while (val.size() > 1){
            String val1 = val.pop();
            String val2 = val.pop();
            if(op.peek() == '+') val.push('+' + val2 + val1);
            if(op.peek() == '-') val.push('-' + val2 + val1);
            if(op.peek() == '*') val.push('*' + val2 + val1);
            if(op.peek() == '/') val.push('/' + val2 + val1);
            op.pop();
        }
        return val.peek();
    }
    public static void main(String[] args) {
        String str = "9-(4+3)*4/6";
        String ans =  convert(str);
        System.out.println(ans);


    }
}
