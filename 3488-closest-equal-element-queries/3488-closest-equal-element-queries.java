class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        // Step 1: Group indices by value
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Step 2: Process each query
        for (int qIdx : queries) {
            int val = nums[qIdx];
            List<Integer> indices = indexMap.get(val);
            
            // If the element only appears once, there's no "other" index
            if (indices.size() <= 1) {
                result.add(-1);
                continue;
            }
            
            // Find the position of qIdx in the sorted list
            int pos = Collections.binarySearch(indices, qIdx);
            
            // The neighbors in the sorted list (circularly)
            int prevIdx = (pos - 1 + indices.size()) % indices.size();
            int nextIdx = (pos + 1) % indices.size();
            
            int d1 = getCircularDist(qIdx, indices.get(prevIdx), n);
            int d2 = getCircularDist(qIdx, indices.get(nextIdx), n);
            
            result.add(Math.min(d1, d2));
        }
        
        return result;
    }
    
    private int getCircularDist(int i, int j, int n) {
        int absDist = Math.abs(i - j);
        return Math.min(absDist, n - absDist);
    }
}