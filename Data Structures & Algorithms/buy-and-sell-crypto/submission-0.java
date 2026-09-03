class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0; //buy day
        for(int right = 1; right<prices.length; right++){ //sell day
            if(prices[right] < prices[left])
                left = right; 
            else{
                int diff = prices[right] - prices[left];
                profit = Math.max(profit, diff);
            }
                        
        }
        return profit;
    }
}
