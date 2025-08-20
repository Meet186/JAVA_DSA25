import java.text.CollationElementIterator;
import java.util.Arrays;

import static java.util.Collections.swap;

public class Rectangle {
    static int reverse(int n){
        int rev = 0;
        while (n > 0){
            int rem = n%10;
            rev = rev * 10 + rem;
            n /=10;
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(reverse(54321));
    }
}
