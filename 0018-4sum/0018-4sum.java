class Solution {
     public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    Arrays.sort(nums);

    for (int i = 0; i < n - 1; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        for (int j = i + 1; j < n - 1; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            int p = j + 1, q = n - 1;
            while (p < q) {
                long sum = (long)nums[i] + nums[j] + nums[p] + nums[q];
                if (sum < target) {
                    p++;
                } else if (sum > target) {
                    q--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                    while (p < q && nums[p] == nums[p + 1]) p++;
                    while (p < q && nums[q] == nums[q - 1]) q--;

                    p++;
                    q--;
                }
            }
        }
    }
    return result;
}

}