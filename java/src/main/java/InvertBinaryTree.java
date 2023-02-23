public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return root;

    var left = invertTree(root.left);
    var right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }
}
