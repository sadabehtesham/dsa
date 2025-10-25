class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        per(nums,used,res,curr);
        return res;
    }
    public void per(int[] nums, boolean[] used,List<List<Integer>> res,List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                curr.add(nums[i]);
                per(nums,used,res,curr);
                curr.remove(curr.size()-1);
                used[i]=false;
            }
        }

        
    }
}