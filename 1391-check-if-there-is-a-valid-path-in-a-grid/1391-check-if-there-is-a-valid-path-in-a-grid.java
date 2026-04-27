 class Solution {
    // Maps street type to [dy, dx] directions it connects
    // Directions: 0: Up, 1: Right, 2: Down, 3: Left
    private int[][][] directions = {
        {}, // 0 (unused)
        {{0, -1}, {0, 1}},  // 1: left, right
        {{-1, 0}, {1, 0}},  // 2: upper, lower
        {{0, -1}, {1, 0}},  // 3: left, lower
        {{0, 1}, {1, 0}},   // 4: right, lower
        {{0, -1}, {-1, 0}}, // 5: left, upper
        {{0, 1}, {-1, 0}}   // 6: right, upper
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            int streetType = grid[r][c];
            for (int[] dir : directions[streetType]) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // Check if the neighbor can connect back to current cell
                    if (canConnect(nr, nc, r, c, grid)) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    private boolean canConnect(int nextR, int nextC, int currR, int currC, int[][] grid) {
        int nextStreet = grid[nextR][nextC];
        for (int[] dir : directions[nextStreet]) {
            if (nextR + dir[0] == currR && nextC + dir[1] == currC) {
                return true;
            }
        }
        return false;
    }
}