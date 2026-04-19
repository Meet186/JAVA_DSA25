package Math;

public class ncr {

    static long NcR(int n,int r){ // also print n number of pascale traingle
         long res = 1;
        for(int i=0; i<r; i++){
            res = res * (n-i);
            res = res/(i+1);
        }
        return res;
    }

    static void printNthRowOfpascaleTraingle(int n){
        int ans = 1;
        System.out.print(ans + " ");
        for (int i = 1; i < n; i++) {
            ans = ans * (n-i);
            ans = ans/i;
            System.out.print(ans + " ");

        }
    }

    public static void main(String[] args) {
        printNthRowOfpascaleTraingle(5);
    }



}
