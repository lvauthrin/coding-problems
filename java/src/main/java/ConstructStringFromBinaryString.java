class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
       if (root == null) return null;

       var left = tree2str(root.left); 
       var right = tree2str(root.right); 

       var ans = "" + root.val;

       if (left == null && right != null) ans += "()(" + right + ")";
       else if (right != null) ans += "(" + left + ")(" + right + ")";
       else if (left != null) ans += "(" + left + ")";
       return ans;
    }
}
