class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] linearPoints = new long[n];
        
        // Step 1: Linearize the square boundary
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (y == 0) linearPoints[i] = x;                         // Bottom edge
            else if (x == side) linearPoints[i] = side + y;          // Right edge
            else if (y == side) linearPoints[i] = 2L * side + (side - x); // Top edge
            else linearPoints[i] = 3L * side + (side - y);           // Left edge
        }
        
        Arrays.sort(linearPoints);
        long totalPerim = 4L * side;
        
        // Step 2: Binary Search on the result
        int low = 1, high = 2 * side;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(linearPoints, k, mid, totalPerim)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canPlace(long[] pts, int k, int dist, long totalPerim) {
        int n = pts.length;
        // Since it's circular, try starting from various points
        // In practice, checking the first few points is usually sufficient 
        // due to the greedy nature and the gap between pts[n-1] and pts[0].
        for (int i = 0; i < n; i++) {
            if (i > 0 && pts[i] == pts[i-1]) continue; 
            // Optimization: Only need to check a limited starting range 
            // relative to the first point's gap.
            if (pts[i] > pts[0] + dist) break; 
            
            int count = 1;
            long lastPos = pts[i];
            long firstPos = pts[i];
            int curr = i;
            
            for (int j = 1; j < k; j++) {
                // Find next point at least 'dist' away
                int nextIdx = findNext(pts, lastPos + dist);
                if (nextIdx >= n) {
                    count = -1; 
                    break;
                }
                lastPos = pts[nextIdx];
                count++;
            }
            
            // Final check: Manhattan distance between last and first
            // Note: Manhattan distance on a square is tricky; simplified here 
            // to the 1D distance or circular wrapping.
            if (count == k && (totalPerim - (lastPos - firstPos)) >= dist) {
                return true;
            }
        }
        return false;
    }
    
    private int findNext(long[] pts, long target) {
        int l = 0, r = pts.length - 1;
        int res = pts.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (pts[m] >= target) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}