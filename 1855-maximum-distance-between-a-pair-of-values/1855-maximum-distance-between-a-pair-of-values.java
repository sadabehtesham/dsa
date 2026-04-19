class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int maxDist = 0;

        // Iterate through both arrays
        while (i < nums1.length && j < nums2.length) {
            // Check if the condition nums1[i] <= nums2[j] is met
            if (nums1[i] <= nums2[j]) {
                // If valid, update max distance and try to increase j
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                // If invalid, nums1[i] is too large; move i forward
                i++;
                // Optimization: ensure j is at least as large as i
                if (j < i) {
                    j = i;
                }
            }
        }

        return maxDist;
    }
}