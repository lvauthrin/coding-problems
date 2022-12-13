"""
Leetcode: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
"""

from typing import Optional
from collections import deque


class Node:
    """Node class"""

    def __init__(self, val: int = 0, left: "Node" = None, right: "Node" = None):
        self.val = val
        self.left = left
        self.right = right


class Solution:  # pylint: disable=too-few-public-methods
    """solution class"""

    def is_tree_symmetric_recursive(self, root: Optional[Node]) -> bool:
        """main method recursive"""
        if root.left is None and root.right is None:
            return True
        if root.left is None or root.right is None:
            return False

        return self.check_nodes(root.left, root.right)

    def is_tree_symmetric_iterative(self, root: Optional[Node]) -> bool:
        """main method iterative"""

        if root is None:
            return False

        next_level = deque([root])
        level = deque()

        while len(next_level) > 0:
            while len(next_level) > 0:
                node = next_level.popleft()
                if node is not None:
                    level.append(node.right)
                    level.append(node.left)

            i, j = 0, len(level) - 1

            while i <= j:
                left_none = level[i] is None and level[j] is not None
                right_none = level[i] is not None and level[j] is None
                not_none = level[i] is not None and level[j] is not None
                not_equal = not_none and level[i].val != level[j].val
                if left_none or right_none or not_equal:
                    return False

                i += 1
                j -= 1

            next_level = level
            level = deque()

        return True

    def check_nodes(self, left, right):
        """check nodes recursively"""
        if left.val != right.val:
            return False
        result = True

        if left.left is None and right.right is not None:
            return False
        if left.left is not None and right.right is None:
            return False
        if left.right is None and right.left is not None:
            return False
        if left.right is not None and right.left is None:
            return False

        if left.left is not None and right.right is not None:
            result = result and self.check_nodes(left.left, right.right)
        if left.right is not None and right.left is not None:
            result = result and self.check_nodes(left.right, right.left)

        return result


def __main__():
    tester = Solution()

    tree1 = Node(Node(1), Node(1))
    tester.is_tree_symmetric_recursive(tree1)
