"""
Leetcode: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
"""

from typing import Optional

class Node:
  """ Node class """
  def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
    self.val = val
    self.left = left
    self.right = right
    self.next = next

class Solution: # pylint: disable=too-few-public-methods
  """ solution class """

  def is_tree_symmetric_recursive(self, root: Optional[TreeNode]) -> bool:
    """ main method recursive """
    if root.left is None and root.right is None:
      return True
    if root.left is None or root.right is None:
      return False

    return self.checkNodes(root.left, root.right)

  def is_tree_symmetric_iterative(self, root: Optional[TreeNode]) -> bool:
    """ main method iterative """
    pass

  def checkNodes(self, left, right):
    if left.val != right.val:
      return False
    result = True

    if left.left is None and right.right != None:
      return False
    if left.left != None and right.right is None:
      return False
    if left.right is None and right.left != None:
      return False
    if left.right != None and right.left is None:
      return False

    if left.left != None and right.right != None:
      result = result and self.checkNodes(left.left, right.right)
    if left.right != None and right.left != None:
      result = result and self.checkNodes(left.right, right.left)

    return result

    def __main__():
      tester = Solution()

      tree1 = Node(Node(1), Node(1))
      tester.is_tree_symmetric_recursive(tree1)
