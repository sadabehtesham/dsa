class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        com(1,n,k,new ArrayList<>(),res);
        return res;
    }
    public void com(int st,int n,int k,List<Integer> curr,List<List<Integer>> res){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
        }
        for(int i=st;i<=n;i++){
            curr.add(i);
            com(i+1,n,k,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}