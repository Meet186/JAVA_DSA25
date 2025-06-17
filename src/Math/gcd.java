package Math;
public class gcd {
    static int gcd(int a , int b){ // TC - O(log(min(a,b)
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
    static int lcm(int a ,int b){
        return a*b/gcd(a,b);
    }
    static int gcd2(int a ,int b){
        // TC - O(min)a,b)
        int min = Math.min(a,b);
        for (int i = min; i >=1 ; i--) {
            if(a%i == 0 && b%i == 0){
                return i;
            }
        }
        return -1; // never hit
    }
    static int gcd3(int a ,int b){ // TC - O(min(a,b))
        while (a%b != 0){
            int rem = a%b;
            a = b;
            b = rem;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(gcd3(10,15));
    }
}
