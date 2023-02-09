import java.util.Stack;

class SimplifyPath {
  public String simplifyPath(String path) {
    var parts = path.split("/");

    var stack = new Stack<String>();

    for (var i = 1; i < parts.length; i++) {
      if (parts[i].equals("..")) {
        if (!stack.isEmpty())
          stack.pop();
      } else if (parts[i].equals(".") || parts[i].equals("")) {
      } // Do nothing
      else
        stack.push(parts[i]);
    }

    return "/" + String.join("/", stack);
  }
}

/*
 * 
 * /blah//.././something
 * 
 */
