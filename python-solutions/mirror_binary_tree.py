from util import test
from util import tree

class Solution:
  def __init__(self):
    pass

  def solve(self: tree.Tree, other: tree.Tree | None) -> tree.Tree | None:
    if other is None:
      return

    other.left, other.right = other.right, other.left
    self.solve(other.left)
    self.solve(other.right)
    return other

def main():
  test.validate(
    tree.Tree("c"),
    Solution().solve(
      tree.Tree("c")
    )
  )
  test.validate(
    tree.Tree("c",
      tree.Tree("d",
        tree.Tree("g"),
        tree.Tree("e", 
          None,
          tree.Tree("h")
        )
      ),
      tree.Tree("b",
        None,
        tree.Tree("a")
      ),
    ),
    Solution().solve(
      tree.Tree("c",
        tree.Tree("b",
          tree.Tree("a")
        ),
        tree.Tree("d",
          tree.Tree("e",
            tree.Tree("h")
          ),
          tree.Tree("g")
        ),
      )
    )
  )

if __name__ == "__main__":
  main()
