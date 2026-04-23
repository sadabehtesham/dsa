class Solution {
    public long[] distance(int[] nums) {
        
        int n = nums.length;
        long[] arr = new long[n];
        
        // Maps to store: sum of indices seen so far, and the count of occurrences
        Map<Integer, Long> prefixSum = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        // Left-to-Right Pass: Calculate distances from indices to the left
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (count.containsKey(val)) {
                long totalBefore = count.get(val);
                long sumBefore = prefixSum.get(val);
                // Formula: (current_index * count_before) - sum_of_indices_before
                arr[i] += (i * totalBefore) - sumBefore;
            }
            prefixSum.put(val, prefixSum.getOrDefault(val, 0L) + i);
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        
        // Reset maps for the Right-to-Left Pass
        prefixSum.clear();
        count.clear();
        
        // Right-to-Left Pass: Calculate distances from indices to the right
        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            if (count.containsKey(val)) {
                long totalAfter = count.get(val);
                long sumAfter = prefixSum.get(val);
                // Formula: sum_of_indices_after - (current_index * count_after)
                arr[i] += sumAfter - (i * totalAfter);
            }
            prefixSum.put(val, prefixSum.getOrDefault(val, 0L) + i);
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        
        return arr;
    }
}