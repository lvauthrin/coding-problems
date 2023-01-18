import java.util.Stack;

class ReversePolishNotation {
  private Integer toNumber(String token) {
    try {
      return Integer.parseInt(token);
    } catch (Exception e) {
      return null;
    }
  }

  public int evalRPN(String[] tokens) {
    var stack = new Stack<Integer>();

    for (var token : tokens) {
      var num = toNumber(token);

      if (num == null) {
        var second = stack.pop();
        var first = stack.pop();

        var answer = switch (token) {
          case "+" -> first + second;
          case "-" -> first - second;
          case "*" -> first * second;
          case "/" -> first / second;
          default -> 0;
        };
        stack.push(answer);
      } else {
        stack.push(num);
      }
    }

    return stack.pop();
  }
}
