class Solution {
    public int maxProfit(int[] prices) {
        //merge rezolvata si cu sliding window si tot asa, daca:
        //prices[right] < prices[left] then left = right, altfel exact ce am eu pe else
        int maxProfit = 0;
        int buy = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }
        }
        return maxProfit;
    }
}
