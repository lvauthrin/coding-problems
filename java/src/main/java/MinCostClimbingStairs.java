class MinCostClimbingStairs {
  public int minCostClimbingStairsVars(int[] cost) {
    var first = 0;
    var second = 0;
    var total = 0;

    for (int i = 2; i <= cost.length; i++) {
      total = (first + cost[i - 2] > second + cost[i - 1] ? cost[i - 1] + second : cost[i - 2] + first);
      first = second;
      second = total;
    }

    return second;
  }

  public int minCostClimbingStairsInPlace(int[] cost) {
    for (int i = 2; i < cost.length; i++) {
      cost[i] = cost[i] + (cost[i - 1] > cost[i - 2] ? cost[i - 2] : cost[i - 1]);
    }

    return cost[cost.length - 1] > cost[cost.length - 2] ? cost[cost.length - 2] : cost[cost.length - 1];
  }

  public int minCostClimbingStairs(int[] cost) {
    // return minCostClimbingStairsVars(cost);
    return minCostClimbingStairsInPlace(cost);
  }
}

/*
 * [ 10, 15, 20]
 * 0 0 10 15
 * 
 * [1 ,100 ,1 ,1 ,1 ,100 ,1 ,1 ,100 ,1]
 * 0 0 1 1 2 101 3 4 4 5 6
 */
