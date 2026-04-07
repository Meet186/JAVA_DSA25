package DP;

import java.util.Arrays;

public class leetcode1048 {
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[][] dp = new int[n + 1][n + 1]; // prev from -1 → n-1

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lis(-1, 0, words, dp);
    }

    private int lis(int prev, int idx, String[] words, int[][] dp) {
        if (idx == words.length) return 0;

        if (dp[idx][prev + 1] != -1) return dp[idx][prev + 1];

        int take = 0;

        // take
        if (prev == -1 || ispred(words[prev], words[idx])) {
            take = 1 + lis(idx, idx + 1, words, dp);
        }

        // skip
        int skip = lis(prev, idx + 1, words, dp);

        return dp[idx][prev + 1] = Math.max(take, skip);
    }
    private boolean ispred(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (n - m != 1) return false;

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }

}
