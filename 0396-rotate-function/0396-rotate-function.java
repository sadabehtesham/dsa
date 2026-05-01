class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f0 = 0;
        
        // Calculate total sum of array and the initial F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += (long) i * nums[i];
        }
        
        long maxVal = f0;
        long currentF = f0;
        
        // Iteratively calculate F(1) to F(n-1) using the pattern
        for (int i = 1; i < n; i++) {
            // F(i) = F(i-1) + sum - n * last_element_of_previous_rotation
            currentF = currentF + sum - (long) n * nums[n - i];
            maxVal = Math.max(maxVal, currentF);
        }
        
        return (int) maxVal;
    }
}