package Math;

public class oddEven {
    public static void main(String[] args) {
        int n = 77;
        System.out.println(isodd(n));
    }

    public static boolean isodd(int n) {
        return ((n & 1) == 1);
    }
}
