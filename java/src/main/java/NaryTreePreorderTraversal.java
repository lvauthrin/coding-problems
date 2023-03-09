import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NaryTreePreorderTraversal {
  public static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  public List<Integer> preorder(Node root) {
    if (root == null)
      return Collections.emptyList();

    var items = new LinkedList<Integer>();
    items.add(root.val);

    for (var child : root.children) {
      var children = preorder(child);

      if (children.size() > 0) {
        items.addAll(children);
      }
    }

    return items;
  }
}
