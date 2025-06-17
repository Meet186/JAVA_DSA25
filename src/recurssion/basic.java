package recurssion;
public class basic {
    static int fib(int n){
        if(n < 2) return n;
        return fib(n-1) + fib(n-2); // not a tail recurssion
    }
    static void print(int n){
        if(n == 0) return;
        print(n-1); // tail recurssion
        System.out.println(n);
    }
    static int binarySerch(int[] arr, int target,int s,int e){
        if(s > e) {
            return -1;
        }
        int m = s + (e-s)/2;
        if(target == arr[m]){
            return m;
        }
        if(target < arr[m]){
          return binarySerch(arr, target, s, m-1);
        }
       return binarySerch(arr, target, m+1, e);
    }
    public static void main(String[] args) {
        int[] arr = {1,4,5,8,9,10,12,50};
        System.out.println(binarySerch(arr,12,0,arr.length-1));
    }
}
