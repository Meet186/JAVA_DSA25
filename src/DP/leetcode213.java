package DP;

import java.util.Arrays;

public class leetcode213 {
    public int solve(int[] nums,int index,int[] dp,int n){
        if(index > n) return 0;
        if(dp[index] != -1) return dp[index];
        int take = nums[index] + solve(nums,index+2,dp,n);
        int pass = solve(nums,index+1,dp,n);
        return dp[index] = Math.max(take,pass);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int take_0th_house = solve(nums,0,dp,n-2);
        Arrays.fill(dp,-1);
        int take_1st_house = solve(nums,1,dp,n-1);
        return Math.max(take_0th_house ,take_1st_house);
    }
}
