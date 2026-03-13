package DP.knapsack;
public class leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int [][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, nums, target, dp);
    }
    private boolean helper(int index, int[] arr, int target, int[][] dp){
        if(target == 0) return true;
        if(index == arr.length) return false;
        if(dp[index][target] != -1) return dp[index][target] == 1;
        boolean skip = helper(index + 1, arr, target, dp);
        boolean take = false;
        if(target >= arr[index]){
            take = helper(index + 1, arr, target - arr[index], dp);
        }
        boolean ans = take || skip;
        dp[index][target] = ans ? 1 : 0;
        return ans;
    }
    public static void main(String[] args) {

    }
}
