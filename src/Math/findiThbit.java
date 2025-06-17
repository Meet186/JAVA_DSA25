package Math;

public class findiThbit
{
    public static void main(String[] args) {
        int n = 10;
        int bit = 1;
        System.out.println(ithBit(n,bit));
    }

    public static int ithBit(int n,int i) {
       int mask = 1 << i;
       int ans = (n & mask) != 0 ? 1 : 0;
       return ans;
    }
}
