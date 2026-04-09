package DP;

public class leetcode1420 {
    int M, N, K;
    int MOD = 1000000007;
    int[][][] dp;

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;

        dp = new int[n][k + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int q = 0; q <= m; q++) {
                    dp[i][j][q] = -1;
                }
            }
        }

        return solve(0, 0, 0);
    }

    private int solve(int idx, int searchCost, int maxSoFar) {
        if (searchCost > K) return 0;

        if (idx == N) {
            return searchCost == K ? 1 : 0;
        }

        if (dp[idx][searchCost][maxSoFar] != -1) {
            return dp[idx][searchCost][maxSoFar];
        }

        long result = 0;

        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar) {
                result += solve(idx + 1, searchCost + 1, i);
            } else {
                result += solve(idx + 1, searchCost, maxSoFar);
            }
            result %= MOD;
        }

        return dp[idx][searchCost][maxSoFar] = (int) result;
    }
}
