import java.util.Stack;

class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    var stack = new Stack<Integer>();

    for (var a : asteroids) {
      if (stack.isEmpty())
        stack.push(a);
      else {
        var tmp = a;
        var push = true;

        while (!stack.isEmpty() && tmp < 0 && stack.peek() > 0) {
          var cur = stack.pop();
          if (Math.abs(tmp) == Math.abs(cur)) {
            push = false;
            break;
          } else if (Math.abs(tmp) < Math.abs(cur))
            tmp = cur;
        }

        if (push)
          stack.push(tmp);
      }
    }

    var i = stack.size() - 1;
    var ans = new int[stack.size()];

    while (!stack.isEmpty())
      ans[i--] = stack.pop();
    return ans;
  }
}
