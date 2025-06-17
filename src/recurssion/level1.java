package recurssion;

public class level1 {

    // print n to 1
    static void printnto1(int n){
        if(n == 1){
            return;
        }
        System.out.println(n);
        print1toN(n-1);
    }

    // print 1 to n
    static void print1toN(int n){
        if(n == 0){
            return;
        }
        print1toN(n-1);
        System.out.println(n);
    }

    static int factorial(int n){
        if(n == 2){
            return n;
        }
        return n * factorial(n-1);

    }

    static int sumOfDigit(int n,int ans){
        if(n == 0){
           return ans;
        }
        return sumOfDigit(n/10,ans + n%10);
    }

    static int reversed(int n,int reversed){
        if(n == 0){
            return reversed;
        }
        return reversed(n/10,reversed * 10 + n%10);
    }
    static int countZeros(int n,int count){
        if(n == 0){
            return count;
        }
        int rem = n%10;
        if(rem == 0){
            return countZeros(n/10,count+1);
        }
        return countZeros(n/10,count);
    }
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    private int helper(int num, int ans) {
        if(num == 0) return ans;
        if(num%10 == 0){
            return helper(num/10,ans + 1);
        }
        return helper(num-1,ans+1);
    }
    public static void main(String[] args) {
        System.out.println(countZeros(14,0));
    }
}
