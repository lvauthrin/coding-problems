import java.util.Stack;

class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    var ans = new int[temperatures.length];
    var stack = new Stack<int[]>();
    stack.push(new int[] { temperatures[0], 0 });

    for (var i = 1; i < temperatures.length; i++) {
      var temperature = temperatures[i];

      while (!stack.isEmpty() && temperature > stack.peek()[0]) {
        var item = stack.pop();
        ans[item[1]] = i - item[1];
      }

      stack.push(new int[] { temperature, i });
    }

    for (var item : stack)
      ans[item[1]] = 0;

    return ans;
  }
}
