class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int curr = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] > curr){
                total += prices[i] - curr;
                curr = prices[i];
            }else{
                curr = prices[i];
            }
        }
        return total;
    }
}