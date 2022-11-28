from collections import deque

class ReprType:
  BFS = 1
  IN_ORDER = 2

"""doc"""
class Tree:
  def __init__(self, value, left = None, right = None, repr_mode = ReprType.BFS):
    self.value = value
    self.left = left
    self.right = right
    self.repr_mode = repr_mode

  def in_order(self):
    """doc"""
    left = right = ""
    value = self.value

    if self.left is not None:
      left = self.left.in_order()
    if self.right is not None:
      right = self.right.in_order()

    return f"{left} {value} {right}"

  def bfs(self):
    stack = deque([self])
    values = []

    while len(stack) > 0:
      node = stack.pop()
      values.append(node.value)

      if (node.left is not None):
        stack.appendleft(node.left)
      if (node.right is not None):
        stack.appendleft(node.right)

    return ", ".join(values)

  def __repr__(self):
    """doc"""
    if self.repr_mode == ReprType.BFS:
      return self.bfs()
    else:
      self.in_order()

def main():
  """doc"""
  tree1 = Tree("a")
  tree2 = Tree("b", Tree("a"), Tree("c"))
  tree3 = Tree("a", Tree("b", Tree("d")), Tree("c", None, Tree("e")))
  tree4 = Tree("a", Tree("b", Tree("d")), Tree("c", None, Tree("e")), ReprType.IN_ORDER)

  for tree in [tree1, tree2, tree3, tree4]:
    print(tree)

if __name__ == "__main__":
  main()