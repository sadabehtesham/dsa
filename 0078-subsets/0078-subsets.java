class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        sub(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void sub(int[] nums,int ind,List<Integer> curr ,List<List<Integer>> res){
         res.add(new ArrayList<>(curr));
        for(int i=ind;i<nums.length;i++){
            curr.add(nums[i]);
            sub(nums,i+1,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}