import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
  public Node cloneGraph(Node node) {
    // Store all "seen" nodes. Do a BFS on the neighbors and copy them in the graph.
    if (node == null)
      return null;

    var newNode = new Node(node.val, new ArrayList<Node>());
    var queue = new LinkedList<Node>();
    var seen = new HashMap<Integer, Node>();

    queue.offer(node);
    seen.put(node.val, newNode);

    while (!queue.isEmpty()) {
      var curr = queue.poll();

      for (var child : curr.neighbors) {
        final Node newChild;

        if (!seen.containsKey(child.val)) {
          newChild = new Node(child.val, new ArrayList<>());
          seen.put(child.val, newChild);
          queue.offer(child);
        } else {
          newChild = seen.get(child.val);
        }

        seen.get(curr.val).neighbors.add(newChild);
      }

    }

    return newNode;
  }
}
