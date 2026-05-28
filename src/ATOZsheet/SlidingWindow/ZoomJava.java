package ATOZsheet.SlidingWindow;

public class ZoomJava {
    class ArithmeticOperation extends ArithmeticException {
        // SUM
        public int sum(int A, int B) {
            return A + B;
        }

        public int sum(int A, int B, int C) {
            return A + B + C;
        }

        public int sum(int... A) { // {1,2,3,4,5,....}
            int total = 0;

            for (int num : A) {
                total += num;
            }

            return total;
        }
        //SUB
        public int sub(int A, int B) {
            return A - B;
        }

        public int sub(int A, int B, int C) {
            return A - B - C;
        }

        public int sub(int... A) {

            if (A.length == 0)
                return 0;

            int total = A[0];

            for (int i = 1; i < A.length; i++) {
                total -= A[i];
            }

            return total;
        }

       // MUL
        public int multiply(int A, int B) {
            return A * B;
        }

        public int multiply(int A, int B, int C) {
            return A * B * C;
        }

        public int multiply(int... A) {

            if (A.length == 0)
                return 0;

            int total = 1;

            for (int num : A) {
                total *= num;
            }

            return total;
        }

       // DIVIDE
        public double divide(int A, int B) {

            if (B == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }

            return (double) A / B;
        }

        public double divide(int A, int B, int C) {

            if (B == 0 || C == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }

            return (double) A / B / C;
        }

        public double divide(int... A) {

            if (A.length == 0)
                return 0;

            double total = A[0];

            for (int i = 1; i < A.length; i++) {

                if (A[i] == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }

                total /= A[i];
            }

            return total;
        }
    }
    class LogicalOperation {

        // AND
        public boolean andOperation(boolean a, boolean b) {
            return a && b;
        }

        // OR
        public boolean orOperation(boolean a, boolean b) {
            return a || b;
        }

        // NOT
        public boolean notOperation(boolean a) {
            return !a;
        }

        // XOR
        public boolean xorOperation(boolean a, boolean b) {
            return a ^ b;
        }

    }
    static void isOddOrEven(int n){
        if(n % 2 == 0) {
            System.out.println(n + "is Even");
        } else {
            System.out.println(n + "is odd");
        }
    }
    static void table(int n){
        printTable(n,1);
    }
    static void printTable(int n, int i) {
        if(i > 10) return;
        System.out.println(n + " x " + i + " = " + (n * i));
        printTable(n, i + 1);
    }
    static int reverse(int n){
        int reversed = 0;
        while (n > 0){
            int rem = n % 10;
            reversed = reversed * 10 + rem;
            n /= 10; // remove last digit
        }
        return reversed;
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

}
