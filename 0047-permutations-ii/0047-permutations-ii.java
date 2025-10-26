class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curr=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        perm(nums,used,new ArrayList<>(),res);
        return res;
    }
    public void perm(int[] nums, boolean[] used,List<Integer> curr , List<List<Integer>> res){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                used[i]=true;
                curr.add(nums[i]);
                perm(nums,used,curr,res);
                
                used[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}