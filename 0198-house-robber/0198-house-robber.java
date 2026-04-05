class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=-1;
        }
        return robb(0,nums,dp);
    }
    public int robb(int i, int[] nums, int dp[]){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+robb(i+2,nums,dp);
        int skip=0+robb(i+1,nums,dp);
        dp[i]=Math.max(take,skip);
        return dp[i];
    }
}