package ATOZsheet.GreedyAlgo;

import java.util.Arrays;

public class minCoin {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        return solve(coins, amount);
    }

    private int solve(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (memo[amount] != -2)
            return memo[amount];

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = solve(coins, amount - coin);

            if (res >= 0) {
                ans = Math.min(ans, res + 1);
            }
        }

        memo[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return memo[amount];
    }
}
