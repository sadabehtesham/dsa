class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            map.putIfAbsent(nums[i], new ArrayDeque<>());
            Deque<Integer> dq = map.get(nums[i]);

            dq.addLast(i);

            if (dq.size() > 3) {
                dq.pollFirst();
            }

            if (dq.size() == 3) {
                int dist = 2 * (dq.peekLast() - dq.peekFirst()); // ✅ fix
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}