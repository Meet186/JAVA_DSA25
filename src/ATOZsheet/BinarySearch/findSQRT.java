package ATOZsheet.BinarySearch;

public class findSQRT {
    static int sqrt(int n) {
        int si = 1;
        int ei = n;
        int ans = 0;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;


            if ((long) mid * mid <= n) {
                ans = mid;       // store possible answer
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return ans; // floor sqrt
    }

    public static void main(String[] args) {
        int n = 28;
        System.out.println(sqrt(n));
    }
}
