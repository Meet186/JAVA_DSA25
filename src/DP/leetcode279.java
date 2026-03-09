import java.utils.*;
class leetcode279 {
    private int helper(int n,int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n ; i++) {
            int currResult = 1 + helper(n-i*i,dp);
            minCount = Math.min(minCount,currResult);
        }
        return dp[n] =  minCount;

    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
}