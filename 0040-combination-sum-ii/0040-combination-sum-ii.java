class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    public void sum(int[] candidates,int target,int st, List<Integer> curr, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target <0) {
            return;
        }
        for(int i=st;i<candidates.length;i++){
            if(i>st && candidates[i]==candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            sum(candidates,target-candidates[i],i+1,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}