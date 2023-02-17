import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    var stack = new Stack<String>();
    var ends = new HashMap<String, String>() {
      {
        put(")", "(");
        put("}", "{");
        put("]", "[");
      }
    };

    for (int i = 0; i < s.length(); i++) {
      var chr = s.substring(i, i + 1);

      if (ends.containsKey(chr)) {
        if (stack.isEmpty() || !stack.pop().equals(ends.get(chr))) {
          return false;
        }
      } else {
        stack.push(chr);
      }
    }

    return stack.isEmpty();
  }
}
