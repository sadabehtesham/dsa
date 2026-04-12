class Solution {
    public int minimumDistance(String word) {
        int[][] dp = new int[word.length() + 1][27];
        for (int i = 0; i <= word.length(); i++) {
            Arrays.fill(dp[i], 300 * 100); // Initialize with a large value
        }
        
        // Initial state: both fingers are free (cost 0)
        dp[0][26] = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i) - 'A';
            int prev = i > 0 ? word.charAt(i - 1) - 'A' : 26;
            
            for (int other = 0; other <= 26; other++) {
                if (dp[i][other] >= 300 * 100) continue;
                
                // Option 1: Move the finger that was at 'prev' to 'curr'
                dp[i + 1][other] = Math.min(dp[i + 1][other], dp[i][other] + getDist(prev, curr));
                
                // Option 2: Move the finger that was at 'other' to 'curr'
                dp[i + 1][prev] = Math.min(dp[i + 1][prev], dp[i][other] + getDist(other, curr));
            }
        }
        
        int minDistance = Integer.MAX_VALUE;
        for (int d : dp[word.length()]) {
            minDistance = Math.min(minDistance, d);
        }
        return minDistance;
    }

    private int getDist(int a, int b) {
        if (a == 26 || b == 26) return 0; // Starting cost is free
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}