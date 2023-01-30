class BestTimeBuySellStock {
  public int maxProfit(int[] prices) {
    // Iterate through the array and keep track of increase
    // If the price drops below the min at any time then start again

    int min = prices[0], curMax = 0, max = 0;

    for (int i = 1; i < prices.length; i++) {
      var price = prices[i];

      if (price >= min) {
        curMax += price - prices[i - 1];
      } else if (price < min) {
        min = price;
        curMax = 0;
      }

      max = Math.max(max, curMax);
    }

    return max;
  }
}
