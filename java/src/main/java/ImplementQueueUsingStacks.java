import java.util.Stack;

class ImplementQueueUsingStacks {
  Stack<Integer> a = new Stack<Integer>();
  Stack<Integer> b = new Stack<Integer>();

  public ImplementQueueUsingStacks() {

  }

  public void push(int x) {
    var tmp = (a.isEmpty()) ? a : b;
    var dest = (a.isEmpty()) ? b : a;

    while (!dest.isEmpty()) {
      tmp.push(dest.pop());
    }

    dest.push(x);

    while (!tmp.isEmpty()) {
      dest.push(tmp.pop());
    }
  }

  public int pop() {
    return (a.isEmpty()) ? (b.isEmpty()) ? -1 : b.pop() : a.pop();
  }

  public int peek() {
    return (a.isEmpty()) ? (b.isEmpty()) ? -1 : b.peek() : a.peek();
  }

  public boolean empty() {
    return a.isEmpty() && b.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// a = 1 2 3 4
// b = 3 2 1
//
//
