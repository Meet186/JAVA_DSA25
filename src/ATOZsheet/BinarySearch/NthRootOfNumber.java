package ATOZsheet.BinarySearch;

public class NthRootOfNumber {

    static int find(int n, int m) {
        int si = 1;
        int ei = m;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            long val = pow(mid, n);

            if (val == m) return mid;
            else if (val > m) ei = mid - 1;
            else si = mid + 1;
        }
        return -1;
    }

    static long pow(long x, int y) {
        if (y == 0) return 1;

        long half = pow(x, y / 2);

        if (half > Long.MAX_VALUE / half) return Long.MAX_VALUE;

        long result = half * half;

        if (y % 2 == 1) {
            if (result > Long.MAX_VALUE / x) return Long.MAX_VALUE;
            result *= x;
        }

        return result;
    }

    public static void main(String[] args) {
        int m = 27;
        int n = 3;
        System.out.println(find(n, m));
    }
}