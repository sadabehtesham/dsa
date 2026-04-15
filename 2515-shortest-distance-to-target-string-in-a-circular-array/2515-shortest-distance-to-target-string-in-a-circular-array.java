class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                // Calculate direct distance
                int diff = Math.abs(i - startIndex);
                
                // Calculate circular distance and find the minimum for this index
                int currentDistance = Math.min(diff, n - diff);
                
                // Update global minimum
                minDistance = Math.min(minDistance, currentDistance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}