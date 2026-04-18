class Solution {
    public int mirrorDistance(int n) {
        long original = n;
        long reversed = 0;
        long temp = n;

        // Step 2: Reverse the digits
        while (temp > 0) {
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
        }

        // Step 3: Return the absolute difference
        return (int) Math.abs(original - reversed);
    }
}