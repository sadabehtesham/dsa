class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] flattened = new int[m * n];
        
        int firstValRemainder = grid[0][0] % x;
        int k = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Hint 1: If remainders differ, it's impossible
                if (grid[i][j] % x != firstValRemainder) {
                    return -1;
                }
                flattened[k++] = grid[i][j];
            }
        }
        
        // Hint 3: Sort to find the median
        Arrays.sort(flattened);
        
        int median = flattened[flattened.length / 2];
        int operations = 0;
        
        for (int val : flattened) {
            // Hint 2: Sum the steps needed to reach the median
            operations += Math.abs(val - median) / x;
        }
        
        return operations;
    }
}