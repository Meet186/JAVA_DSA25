package ATOZsheet;

import java.util.HashMap;

public class largestSubarraysum0 {

    public static int maxLen(int[] arr) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j <arr.length ; j++) {
                sum += arr[j];
                if(sum == 0){
                    len = Math.max(len,j-i + 1);
                }
            }
        }
        return len;
    }
    public static int  maxLen2(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));
    }
}
