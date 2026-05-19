package ATOZsheet.SlidingWindow;

public class leetcode930 {
    private int solve(int[] nums,int goal){
        if(goal < 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = 0;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums,goal) - solve(nums,goal-1);
    }
    public static void main(String[] args) {

    }
}
