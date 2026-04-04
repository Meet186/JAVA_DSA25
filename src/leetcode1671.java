public class leetcode1671 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        // fill LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    LIS[i] = Math.max(LIS[i],LIS[j]);
                }
            }
            LIS[i] += 1;
        }

        // fill LDS
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if(nums[j] < nums[i]){
                    LDS[i] = Math.max(LDS[i],LDS[j]);
                }
            }
            LDS[i] += 1;
        }

        int minRemoval = n;
        for (int i = 0; i < n; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) { // valid peak
                int mountainLength = LIS[i] + LDS[i] - 1;
                minRemoval = Math.min(minRemoval, n - mountainLength);
            }
        }


        return minRemoval;
    }
}
