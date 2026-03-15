package DP.knapsack;
public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount+1; j++) {
                dp[i][j] = -1;
            }
        }
       int ans = (int) helper(0,coins,amount,dp);
       if(ans == Integer.MAX_VALUE) return -1;
       return ans;
    }
    private long helper(int index,int[] coins,int amount,long[][] dp ){
        if(index == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        long skip = helper(index+1,coins,amount,dp);
        if(amount-coins[index] < 0) return dp[index][amount] = skip;
        long pick = 1 +  helper(index, coins, amount-coins[index],dp);
        return dp[index][amount] = Math.min(skip,pick);
    }
}
