""" 
Leetcode: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
"""

from typing import List

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
    if root.left == None and root.right == None: return True
    if root.left == None or root.right == None: return False
    
    return self.checkNodes(root.left, root.right)
  
  def is_tree_symmetric_iterative(self, root: Optional[TreeNode]) -> bool:
    """ main method iterative """
    pass
  
  def checkNodes(self, l, r):
    if l.val != r.val: return False
    result = True
    
    if l.left == None and r.right != None: return False
    if l.left != None and r.right == None: return False
    if l.right == None and r.left != None: return False
    if l.right != None and r.left == None: return False
      
    if l.left != None and r.right != None:
      result = result and self.checkNodes(l.left, r.right)
    if l.right != None and r.left != None:
      result = result and self.checkNodes(l.right, r.left)
      
    return result
