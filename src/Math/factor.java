package Math;

import java.util.ArrayList;
import java.util.List;

public class factor {
    static void factor(int n){
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                System.out.print(i + " ");
            }

        }
    }

    static void factor2(int n){
        List<Integer> ll = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {

            if(n % i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                } else {
                    ll.add(n/i);
                    System.out.print(i + " ");
                }

            }

        }
        for (int i = ll.size()-1; i >= 1 ; i--) {
            System.out.print(ll.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        factor2(36);
    }
}

