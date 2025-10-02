class Solution {
    public int maxArea(int[] height) {
        int maxwater=0;
        int lp=0;
        int rp=height.length-1;
        while(lp<rp){
            int wt= rp-lp;
            int ht=Math.min(height[lp], height[rp]);
            int currwater= wt*ht;
            maxwater=Math.max(currwater , maxwater);
            if(height[lp]<height[rp]){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxwater;
    }
}