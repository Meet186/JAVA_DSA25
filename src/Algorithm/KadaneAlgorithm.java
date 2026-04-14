package Algorithm;

public class KadaneAlgorithm {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }

            if (currSum < 0) {
                currSum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("Subarray from index " + start + " to " + end);
        return maxSum;
    }
}
