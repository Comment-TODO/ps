class L121 {
    public int maxProfit(int[] prices) {
        int currMinPrice = prices[0];
        int currMaxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {            
            if (prices[i] <= currMinPrice) {
                currMinPrice = prices[i];
            } else {
                currMaxProfit = Math.max(currMaxProfit, prices[i] - currMinPrice);
            }
        }
        
        return currMaxProfit;
    }
}
