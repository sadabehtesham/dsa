class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(nums);
        sub(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void sub(int[] nums,int st,List<Integer> curr,List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=st;i<nums.length;i++){
            if(i>st && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            sub(nums,i+1,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}