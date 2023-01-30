import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestor {
  public List<TreeNode> dfs(TreeNode root, TreeNode target) {
    if (root == null)
      return null;
    if (root.val == target.val) {
      var result = new LinkedList<TreeNode>();
      result.add(target);
      return result;
    }

    var left = dfs(root.left, target);

    if (left != null) {
      left.add(0, root);
      return left;
    }

    var right = dfs(root.right, target);

    if (right != null) {
      right.add(0, root);
      return right;
    }

    return null;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Iterate through tree and keep track of path
    // Repeat for other node: Iterate through tree and keep track of path
    var pathA = dfs(root, p);
    var pathB = dfs(root, q);
    // Go through path and return last node before divergence

    TreeNode answer = null;

    for (int i = 0; i < Math.min(pathA.size(), pathB.size()); i++) {
      if (pathA.get(i).val != pathB.get(i).val)
        break;
      answer = pathA.get(i);
    }

    return answer;
  }
}
