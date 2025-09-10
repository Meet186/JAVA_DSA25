package stackandQueue;
import java.util.*;
public class StringToprefix {
    public static String convert(String str){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascai = (int) ch;
            if(ascai >= 48 && ascai <= 57) val.push(""+ch);
            else if (op.isEmpty() || ch == '(' || op.peek() == '(') op.push(ch);
            else if (ch == ')') { // work till not get '('
                while (op.peek() != '('){
                    String val2 = val.pop();
                    String val1 = val.pop();
                    if(op.peek() == '+') val.push(val1 + val2 + '+');
                    if(op.peek() == '-') val.push(val1 + val2 + '-');
                    if(op.peek() == '*') val.push(val1 + val2 + '*');
                    if(op.peek() == '/') val.push(val1 + val2 + '/');
                    op.pop();
                }
                op.pop(); // remove '(' from the stack
            } else {
                if(ch == '+' || ch == '-'){ // all the priority grater than this so work
                    String val2 = val.pop();
                    String val1 = val.pop();
                    if(op.peek() == '+') val.push(val1 + val2 + '+');
                    if(op.peek() == '-') val.push(val1 + val2 + '-');
                    if(op.peek() == '*') val.push(val1 + val2 + '*');
                    if(op.peek() == '/') val.push(val1 + val2 + '/');
                    op.pop();
                    op.push(ch); // add current operator
                }  if(ch == '*' || ch == '/'){ // high priority if peek of op is * || /
                    if(op.peek() == '*' || op.peek() == '/'){
                        String val2 = val.pop();
                        String val1 = val.pop();

                        if(op.peek() == '*') val.push(val1 + val2 + '*');
                        if(op.peek() == '/') val.push(val1 + val2 + '/');
                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch); // all the priority are less so add operator only
                    }
                }
            }
        }
        // work till val is not grater than 1
        while (val.size() > 1){
            String val2 = val.pop();
            String val1 = val.pop();
            if(op.peek() == '+') val.push(val1 + val2 + '+');
            if(op.peek() == '-') val.push(val1 + val2 + '-');
            if(op.peek() == '*') val.push(val1 + val2 + '*');
            if(op.peek() == '/') val.push(val1 + val2 + '/');
            op.pop();
        }
        return val.peek();
    }
    public static void main(String[] args) {
//        System.out.println(convert(str));
    }
}
