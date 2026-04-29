class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        // Prefix sums for columns to calculate range sums in O(1)
        long[][] pref = new long[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                pref[j][i + 1] = pref[j][i] + grid[i][j];
            }
        }

        // dp[j][h][state]
        // state 0: column j-1 height < column j height (Increasing)
        // state 1: column j-1 height > column j height (Decreasing)
        long[][][] dp = new long[n + 1][n + 1][2];
        for (int j = 0; j <= n; j++) {
            for (int h = 0; h <= n; h++) {
                dp[j][h][0] = dp[j][h][1] = -1;
            }
        }

        // Base case: starting at column 0 with "previous" height 0
        dp[0][0][0] = 0;

        for (int j = 0; j < n; j++) {
            for (int hPrev = 0; hPrev <= n; hPrev++) {
                for (int hCurr = 0; hCurr <= n; hCurr++) {
                    // Scenario 1: Increasing (hPrev <= hCurr)
                    if (dp[j][hPrev][0] != -1) {
                        long score = (hCurr > hPrev && j > 0) ? pref[j - 1][hCurr] - pref[j - 1][hPrev] : 0;
                        dp[j + 1][hCurr][0] = Math.max(dp[j + 1][hCurr][0], dp[j][hPrev][0] + score);
                    }

                    // Scenario 2: Transition from Dec to Inc (Valley)
                    if (dp[j][hPrev][1] != -1) {
                        dp[j + 1][hCurr][0] = Math.max(dp[j + 1][hCurr][0], dp[j][hPrev][1]);
                    }

                    // Scenario 3: Decreasing (hPrev >= hCurr)
                    long base = Math.max(dp[j][hPrev][0], dp[j][hPrev][1]);
                    if (base != -1) {
                        long score = (hPrev > hCurr && j < n) ? pref[j][hPrev] - pref[j][hCurr] : 0;
                        dp[j + 1][hCurr][1] = Math.max(dp[j + 1][hCurr][1], base + score);
                    }
                }
            }
        }

        long maxScore = 0;
        for (int h = 0; h <= n; h++) {
            maxScore = Math.max(maxScore, Math.max(dp[n][h][0], dp[n][h][1]));
        }
        return maxScore;
    }
}