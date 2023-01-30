import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {
  public String serialize(TreeNode root) {
    // Use DFS and write out data
    if (root == null)
      return "null";

    var ans = Integer.toString(root.val);

    var left = serialize(root.left);
    ans = ans.concat(",").concat(left);

    var right = serialize(root.right);
    ans = ans.concat(",").concat(right);

    return ans;
  }

  public void deserializeDfs(TreeNode root, Deque<String> nodes) {
    if (nodes.isEmpty())
      return;

    var left = nodes.removeFirst();
    var leftNode = left.equals("null") ? null : new TreeNode(Integer.valueOf(left));
    root.left = leftNode;
    if (root.left != null)
      deserializeDfs(root.left, nodes);

    var right = nodes.removeFirst();
    var rightNode = right.equals("null") ? null : new TreeNode(Integer.valueOf(right));
    root.right = rightNode;
    if (root.right != null)
      deserializeDfs(root.right, nodes);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    var nodes = new LinkedList<>(Arrays.asList(data.split(",")));
    var rootValue = nodes.removeFirst();

    if (rootValue == "null")
      return null;

    var root = new TreeNode(Integer.valueOf(rootValue));
    deserializeDfs(root, nodes);

    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// [0,1,2, 3, 4,5,6] log2(0+1) => 0 log2(1+1) => 1 log2(2+1) => 1 2^2 - 1
// log2(5+1) => 2 2^2 - 1
// [1,2,3,null,null,4,5]
// BFS
// - Keep track of level to map to array
// - add nulls to store complete tree
/*
 * 1,2 -> 0
 * 3,4 -> 1
 * 5,6 -> 2
 * 7,8 -> 3
 * 9,10 -> 4 => 3 +1
 * 11,12 -> 5 => 3 +2
 * 13,14 -> 6 => 3 +3
 */
