import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
  public String removeDuplicates(String s) {
    var stack = new Stack<Character>();

    for (char c : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek().equals(c)) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    return stack.stream().reduce(
        new StringBuilder(),
        (sb, c) -> sb.append(c),
        StringBuilder::append).toString();
  }
}
