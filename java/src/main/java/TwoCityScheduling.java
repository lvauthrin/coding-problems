import java.util.Arrays;

class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
    var firstHalf = Arrays.stream(costs).limit(costs.length / 2);
    var secondHalf = Arrays.stream(costs).skip(costs.length / 2);

    return firstHalf.map(i -> i[0]).reduce((a, b) -> a + b).orElse(0) +
        secondHalf.map(i -> i[1]).reduce((a, b) -> a + b).orElse(0);

  }
}
