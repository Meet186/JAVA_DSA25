package ATOZsheet.SlidingWindow;

public class leetcode1004 {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int l=0;
        int r=0;
        int n=nums.length;
        int zeros = 0;
        // TC - O(2N)
        while(r < n){ // O(N)
            if(nums[r] == 0){
                zeros++;
            }
            while(zeros > k){ // O(N)
                if(nums[l] == 0) zeros--;
                l++;
            }
            if(zeros <= k){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
}
