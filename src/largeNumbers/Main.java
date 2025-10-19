package largeNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int a = 30;
        int b = 45;

        BigInteger A = BigInteger.valueOf(4517);
        BigInteger B = BigInteger.valueOf(15487879);
        BigInteger C = new BigInteger("478999898454484889544");
        BigInteger X = new BigInteger("47899989845448488954545454");
        BigInteger d = BigInteger.ZERO;

        BigInteger SUM = C.add(X);
        BigInteger MULTIPLY = C.multiply(X);

        if(C.compareTo(X) < 0){
            System.out.println("YES");
        } else  {
            System.out.println("NO");
        }
//        System.out.println(MULTIPLY);

//        System.out.println(Factorial.fact(200055454));

        // BIG DECIMAL
        BigDecimal Y = new BigDecimal("0.1");
        BigDecimal Z = new BigDecimal("0.11");
        System.out.println(Y.add(Z));

    }
}
