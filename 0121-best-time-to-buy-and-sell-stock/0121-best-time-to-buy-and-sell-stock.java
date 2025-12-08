class Solution {
    public int maxProfit(int[] prices) {
        int buyprice=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit=prices[i]-buyprice;
                maxprofit=Math.max(maxprofit,profit);
            }
            else{
                buyprice=prices[i];
            }
        }    
        return maxprofit;
    }
}