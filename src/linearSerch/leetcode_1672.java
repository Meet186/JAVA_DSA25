package linearSerch;

public class leetcode_1672 {
   static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int curr_richest = 0;

        for(int[] num : accounts){
            for(int el : num){
                curr_richest += el;
            }

            if(max < curr_richest){
                max = curr_richest;
            }
            curr_richest =  0;
        }

        return max;
    }
    public static void main(String[] args) {
       int[][] arr = {{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(arr));
    }
}
