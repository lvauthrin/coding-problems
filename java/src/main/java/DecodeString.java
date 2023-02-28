import java.util.Stack;

// Test this out
class DecodeString {
  public String decodeString(String s) {
    var i = 0;
    var charStack = new Stack<StringBuilder>();
    var countStack = new Stack<Integer>();

    charStack.push(new StringBuilder());
    countStack.push(1);

    while (i < s.length()) {
      var c = s.charAt(i);

      if (Character.isLetter(c)) {
        charStack.peek().append(c);
      } else if (c == '[') {
        // Ignore
      } else if (c == ']') {
        var str = charStack.pop().toString().repeat(countStack.pop());
        charStack.peek().append(str);
      } else {
        var num = 0;

        while (Character.isDigit(s.charAt(i))) {
          num = (num * 10) + (s.charAt(i++) - '0');
        }

        if (num > 0) {
          countStack.push(num);
          charStack.push(new StringBuilder());
          i--;
        }
      }

      i++;
    }

    return charStack.pop().toString().repeat(countStack.pop());
  }
}
