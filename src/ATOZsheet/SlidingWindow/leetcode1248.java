package ATOZsheet.SlidingWindow;

public class leetcode1248 {
    private int solve(int[] nums, int goal) {
        if (goal < 0) return 0;

        int l = 0, sum = 0, ans = 0;

        for (int r = 0; r < nums.length; r++) {

            if (nums[r] % 2 != 0) sum++;

            while (sum > goal) {
                if (nums[l] % 2 != 0) sum--;
                l++;
            }

            ans += (r - l + 1);
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }
}
