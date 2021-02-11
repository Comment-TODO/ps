class L121 {
    public int maxProfit(int[] prices) {
        int currMinPrice = prices[0];
        int currMaxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            currMaxProfit = Math.max(currMaxProfit, prices[i] - currMinPrice);
            
            if (prices[i] < currMinPrice) {
                currMinPrice = prices[i];
            }
        }
        
        return currMaxProfit;
    }
}
