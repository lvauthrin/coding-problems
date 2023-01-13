import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
class BinaryTreeLevelOrderTraversal {
  // [3,9,20,null,null,15,7] | n = [], ans = [], s = [3]
  //
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null)
      return Collections.emptyList();

    var queue = new LinkedList<TreeNode>();
    // Can simplify this by keeping track of level and indexing into "answer"
    List<TreeNode> nextLevel = new LinkedList<>();
    List<List<Integer>> answer = new LinkedList<>();

    queue.offer(root);
    answer.add(Collections.singletonList(root.val));

    while (!queue.isEmpty()) {
      var node = queue.pop();

      if (node.left != null)
        nextLevel.add(node.left);
      if (node.right != null)
        nextLevel.add(node.right);

      if (queue.isEmpty() && !nextLevel.isEmpty()) {
        List<Integer> nums = nextLevel.stream()
            .map(n -> n.val)
            .collect(Collectors.toList());
        answer.add(nums);

        for (TreeNode n : nextLevel) {
          queue.offer(n);
        }

        nextLevel = new LinkedList<>();
      }
    }

    return answer;
  }
}
