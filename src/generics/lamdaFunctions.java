package generics;

import java.util.ArrayList;
import java.util.function.Consumer;

public class lamdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.forEach((item) -> System.out.println(item));
        Consumer<Integer> fun = (item) -> System.out.println(item * 2);
        list.forEach(fun);
         operations sum = (a,b) -> a + b;
         operations product = (a,b) -> a * b;
         operations sub = (a,b) -> a - b;

        int ans = lamdaFunctions.operate(4, 5, sum);
        System.out.println(ans);

    }
    public static int operate(int a , int b, operations op){
        return op.operation(a,b);
    }
    interface operations {
        int operation(int a,int b);
    }
}
