package linearSerch;
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class leetcode_1295 {

    static boolean isEven(int num){
        int len = countDigit(num);
        if(len % 2 == 0) return true;
        return false;

    }
    static int countDigit(int num){
        if(num < 0){
           num =  num * -1;
        }
        if(num == 0) num = 1;
        String digit = Integer.toString(num);
        return digit.length();
    }

    static int countDigit2(int num){
        return (int) Math.log10(num + 1);
    }


    static int findNumbers(int[] nums) {
        int count = 0;
        for(int num  : nums){
            if(isEven(num)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
     int [] arr = {12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }
}
