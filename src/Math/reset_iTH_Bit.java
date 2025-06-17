package Math;

public class reset_iTH_Bit {
    public static void main(String[] args) {
        int n = 10;
        int i = 3;
        System.out.println(reset_bit(n,i));

    }
    static String reset_bit(int n , int i){
        int mask = (1 << i);
        int complement = ~mask;
        int ans = n & complement;
        return Integer.toBinaryString(ans);
    }

}
