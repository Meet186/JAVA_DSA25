package Math;

public class primeNum {

    static boolean isPrime(int n ){
        for (int i = 2; i < n ; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static boolean isPrime2(int n ){
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static void isPrime3(int n){
        // TC - O(N*log(logN))
        boolean[] prime = new boolean[n+1];
        for (int i = 2; i * i <=n ; i++) {
            if(!prime[i]){
                for (int j = i*2; j <= n ; j+= i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 2; i <= n ; i++) {
            if(!prime[i]){
                System.out.print(i + " ");
            }

        }


    }
    public static void main(String[] args) {
        int n = 40;
        isPrime3(n);
    }
}
