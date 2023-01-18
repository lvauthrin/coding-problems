import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class CoinChange {
  public int coinChangeDP(int[] coins, int amount) {
    var ways = new long[amount + 1];
    Arrays.fill(ways, Integer.MAX_VALUE);
    ways[0] = 0;

    for (int i = 0; i < ways.length; i++) {
      if (ways[i] >= Integer.MAX_VALUE)
        continue;

      for (int j = 0; j < coins.length; j++) {
        if ((i + coins[j]) < ways.length && coins[j] <= amount) {
          ways[i + coins[j]] = Math.min(ways[i + coins[j]], ways[i] + 1);
        }
      }
    }

    var min = ways[ways.length - 1];
    return (int) (min == Integer.MAX_VALUE ? -1 : min);
    // [0, 1, 2, 3]
    // [0, 0, 1, 0]
    // ^ +2
    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    // [0, 1, 1, 2, 2, 1, 2, 1, 1, 1, 1, 3]
    // ^ +1 +2 +5
  }

  public int coinChange(int[] coins, int amount, Map<Integer, Integer> values) {
    if (amount == 0) {
      return 0;
    }

    if (amount < 0) {
      return -1;
    }

    if (values.containsKey(amount)) {
      return values.get(amount);
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < coins.length; i++) {
      var num = coinChange(coins, amount - coins[i], values);

      if (num != -1) {
        if (num == 2)
          System.out.println(num + " " + coins[i] + " " + amount);
        min = Math.min(min, num + 1);
      }
    }

    values.put(amount, min = min == Integer.MAX_VALUE ? -1 : min);
    return min;
  }

  // [1,2,5] t=10
  // [1,2,5] t=9
  // [1,2,5] t=8
  // [1,2,5] t=7
  // [1,2,5] t=4
  // [1,2,5] t=8
  // [1,2,5] t=7
  // [1,2,5] t=6
  // [1,2,5] t=3
  // [1,2,5] t=5
  // [1,2,5] t=4
  // [1,2,5] t=3
  // [1,2,5] t=0

  public int coinChange(int[] coins, int amount) {
    return coinChangeDP(coins, amount);
    // return coinChange(coins, amount, new HashMap<>());
  }
}
