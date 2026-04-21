 import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        
        // Step 1: Union all allowed swap indices
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        // Step 2: Group indices by their root parent
        Map<Integer, Map<Integer, Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.putIfAbsent(root, new HashMap<>());
            // Count frequency of values in source for this component
            Map<Integer, Integer> counts = components.get(root);
            counts.put(source[i], counts.getOrDefault(source[i], 0) + 1);
        }
        
        int hammingDistance = 0;
        
        // Step 3: Check how many target elements are missing from their respective source components
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> counts = components.get(root);
            
            if (counts.getOrDefault(target[i], 0) > 0) {
                // If target value exists in the pool for this component, "use" it
                counts.put(target[i], counts.get(target[i]) - 1);
            } else {
                // Otherwise, this position must contribute to the Hamming distance
                hammingDistance++;
            }
        }
        
        return hammingDistance;
    }
    
    // Standard Union-Find Helper Class
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]); // Path compression
        }
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) parent[rootI] = rootJ;
        }
    }
}