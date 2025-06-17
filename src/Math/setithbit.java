package Math;

public class setithbit {
    public static void main(String[] args) {
        int n = 10;
        int i = 2;
        System.out.println(setithBit(n,i));
    }

    static int setithBit(int n, int i){
        int mask = 1 << i;
        int ans = n | mask;
        return ans;
    }
}
