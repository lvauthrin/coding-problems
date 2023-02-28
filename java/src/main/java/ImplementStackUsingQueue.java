import java.util.LinkedList;

class MyStack {
  LinkedList<Integer> a = new LinkedList<>();

  public MyStack() {

  }

  public void push(int x) {
    var countToRepush = a.size();
    a.offer(x);

    for (var i = 0; i < countToRepush; i++) {
      a.offer(a.poll());
    }
  }

  public int pop() {
    if (this.empty())
      return -1;
    else
      return a.poll();
  }

  public int top() {
    if (!a.isEmpty())
      return a.peek();
    else
      return -1;
  }

  public boolean empty() {
    return a.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
