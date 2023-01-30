import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreeRightSideView {
  public static class Pair<F, S> {
    F f;
    S s;

    public Pair(F f, S s) {
      this.f = f;
      this.s = s;
    };
  }

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null)
      return Collections.emptyList();
    var ans = new LinkedList<Integer>();
    var queue = new LinkedList<TreeNode>();
    var current = new LinkedList<TreeNode>();
    current.add(root);

    while (!current.isEmpty()) {
      ans.add(current.getLast().val);
      queue = current;
      current = new LinkedList<>();

      while (!queue.isEmpty()) {
        var c = queue.pop();

        if (c.left != null)
          current.offer(c.left);
        if (c.right != null)
          current.offer(c.right);
      }
    }

    return ans;
  }
}
