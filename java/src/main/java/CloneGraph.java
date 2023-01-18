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
        var newChild = seen.containsKey(child.val) ? seen.get(child.val) : new Node(child.val, new ArrayList<>());

        var ns = new Node[] { child, newChild };

        if (!seen.containsKey(child.val)) {
          queue.offer(child);
          seen.put(ns[0].val, newChild);
        }

        seen.get(curr.val).neighbors.add(ns[1]);
      }

    }

    return newNode;
  }
}
