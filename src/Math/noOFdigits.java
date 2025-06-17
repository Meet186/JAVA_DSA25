package Math;

public class noOFdigits {
    public static void main(String[] args) {
        int n = 100000785;
        int base = 2;
        int ans = (int) (Math.log(n)/Math.log(base) + 1); // TC - O(lonN)
        int ans2 = (int) (Math.log(n)/Math.log(10) + 1);
        System.out.println(ans2);
    }
}
