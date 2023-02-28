import java.util.Stack;

class BaseballGame {
  public int calPoints(String[] operations) {
    var stack = new Stack<Integer>();

    for (var operation : operations) {
      switch (operation) {
        case "C":
          stack.pop();
          break;
        case "D":
          stack.push(stack.peek() * 2);
          break;
        case "+":
          var a = stack.pop();
          var b = stack.pop();
          stack.push(b);
          stack.push(a);
          stack.push(a + b);
          break;
        default:
          stack.push(Integer.valueOf(operation));
      }
    }

    var ans = 0;

    while (!stack.isEmpty()) {
      ans += stack.pop();
    }
    return ans;
  }
}
