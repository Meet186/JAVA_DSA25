package DP.twoD_DP;
import java.util.*;



public class leetcode2463 {

    private long solve(int i, int j, List<Integer> robot, List<Integer> position, long[][] dp) {
        if (i == 0) return 0;
        if (j == 0) return (long)1e15;
        if (dp[i][j] != -1) return dp[i][j];
        long take = Math.abs(robot.get(i-1) - position.get(j-1))
                + solve(i -1, j - 1, robot, position, dp);
        long skip = solve(i, j - 1, robot, position, dp);
        return dp[i][j] = Math.min(take, skip);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparing(a -> a[0]));
        List<Integer> position = new ArrayList<>();
        for (int[] f : factory) {
            int pos = f[0];
            int limit = f[1];
            for (int i = 0; i < limit; i++) {
                position.add(pos);
            }
        }
        int m = robot.size();
        int n = position.size();

        long[][] dp = new long[m + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(m, n, robot, position, dp);
    }

    public long minimumTotalDistance2(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparing(a -> a[0]));

        List<Integer> position = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                position.add(f[0]);
            }
        }

        int m = robot.size();
        int n = position.size();

        long[][] dp = new long[m + 1][n + 1];
        long INF = (long)1e15;

        // base cases
        for (int i = 1; i <= m; i++) {
            dp[i][0] = INF; // no positions
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0; // no robots
        }

        // fill DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                long take = Math.abs(robot.get(i - 1) - position.get(j - 1))
                        + dp[i - 1][j - 1];

                long skip = dp[i][j - 1];

                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[m][n];
    }
}
