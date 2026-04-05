class Solution {
    public int rob(int[] nums) {
         int n=nums.length;
         if(n==1) return nums[0];
         int dp1[]=new int[n];
         for(int i=0;i<n;i++){
            dp1[i]=-1;
         }
         // end excluded
         int case1=robb(0,n-2,nums,dp1);

         int dp2[]=new int[n];
         for(int i=0;i<n;i++){
            dp2[i]=-1;
         }
         // start excluded
         int case2=robb(1,n-1,nums,dp2);
         return Math.max(case1,case2);

    }
    public int robb(int i,int end, int[] nums, int dp[]){
        if(i>end){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+robb(i+2,end,nums,dp);
        int skip=0+robb(i+1,end,nums,dp);
        dp[i]=Math.max(take,skip);
        return dp[i];
    }
}