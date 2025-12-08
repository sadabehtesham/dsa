class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rowIndex = -1;
        int maxCount = -1;
        
        for (int i = 0; i < mat.length; i++) {
            int count = 0;

            for (int val : mat[i]) {
                if (val == 1) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxCount};
    }
}