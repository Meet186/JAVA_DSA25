package Math;

public class powerof2
{
    public static void main(String[] args) {
        int n = 30;
        boolean ans = (n & (n-1)) == 0;

        System.out.println(ans);
    }
}
