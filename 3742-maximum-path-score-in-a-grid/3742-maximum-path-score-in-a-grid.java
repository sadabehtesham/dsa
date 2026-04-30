class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i][j][c] stores the max score at (i, j) with cost c
        // Initialize with -1 to represent unreachable states
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Base case: starting at (0, 0)
        // grid[0][0] is always 0 based on constraints
        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;

                    // Try moving Right (i, j + 1) and Down (i + 1, j)
                    int[][] directions = {{0, 1}, {1, 0}};
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        if (ni < m && nj < n) {
                            int cellVal = grid[ni][nj];
                            int nextCost = c + (cellVal == 0 ? 0 : 1);
                            int nextScore = dp[i][j][c] + (cellVal == 0 ? 0 : cellVal);

                            if (nextCost <= k) {
                                dp[ni][nj][nextCost] = Math.max(dp[ni][nj][nextCost], nextScore);
                            }
                        }
                    }
                }
            }
        }

        // Find the maximum score at the bottom-right corner within budget k
        int maxScore = -1;
        for (int c = 0; c <= k; c++) {
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][c]);
        }

        return maxScore;
    }
}