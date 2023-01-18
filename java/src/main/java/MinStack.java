import java.util.Stack;

class MinStack {
  private Stack<Integer> vals = new Stack<Integer>();
  private Stack<Integer> mins = new Stack<Integer>();

  public MinStack() {

  }

  public void push(int val) {
    if (mins.isEmpty() || val <= mins.peek()) {
      mins.push(val);
    }

    vals.push(val);
  }

  public void pop() {
    if (vals.pop().equals(mins.peek())) {
      mins.pop();
    }
  }

  public int top() {
    return vals.peek();
  }

  public int getMin() {
    return mins.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
