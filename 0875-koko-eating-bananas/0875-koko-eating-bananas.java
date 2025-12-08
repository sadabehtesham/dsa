class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; 
        }
        return hours <= h;
    }
}