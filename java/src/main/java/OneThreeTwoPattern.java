import java.util.Stack;

class OneThreeTwoPattern {
  /*
   * 1 3 5 4
   * 5 3 0 6 4 min [3, max5 cur0
   * // Keep track of min
   * // Keep track of max
   * // When current is < last, check min, max and current
   * // Push on stack and when there's a shift then check min,
   */
  public boolean find132pattern(int[] nums) {
    var stack = new Stack<int[]>();
    var min = nums[0];
    stack.push(new int[] { nums[0], min });

    for (var i = 1; i < nums.length; i++) {
      var num = nums[i];

      while (!stack.isEmpty() && stack.peek()[0] <= num) {
        stack.pop();
      }

      if (!stack.isEmpty() && stack.peek()[1] < stack.peek()[0] && stack.peek()[1] < num)
        return true;
      stack.push(new int[] { num, min });
      min = Math.min(min, num);
    }
    return false;
  }
}
