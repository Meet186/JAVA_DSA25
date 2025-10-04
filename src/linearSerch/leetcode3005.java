package linearSerch;

public class leetcode3005 {
    public static int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        int max = 0;
        for(int num : nums){
            freq[num]++;
            max = Math.max(max,freq[num]);
        }
        int ans = 0;
        for(int i=1; i<= 100; i++){
            if(freq[i] == max) ans += max;

        }
        return ans;
    }
}
