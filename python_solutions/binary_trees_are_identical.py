from util import test
from util import tree

class Solution:
  def __init__(self):
    pass

  def solve(self, first, second):
    if (first is None and second is not None) or (second is None and first is not None):
      return False
    elif first is None:
      return True

    return first.value == second.value and \
      self.solve(first.left, second.left) and \
      self.solve(first.right, second.right)

def main():
  test.validate(True,
    Solution().solve(
      tree.Tree("a"),
      tree.Tree("a")
    )
  )
  test.validate(False,
    Solution().solve(
      tree.Tree("b"),
      tree.Tree("a")
    )
  )
  test.validate(True,
    Solution().solve(
      tree.Tree("c",
        tree.Tree("b",
          tree.Tree("a")
        ),
        tree.Tree("d",
          tree.Tree("e",
            tree.Tree("f")
          ),
          tree.Tree("g")
        ),
      ),
      tree.Tree("c",
        tree.Tree("b",
          tree.Tree("a")
        ),
        tree.Tree("d",
          tree.Tree("e",
            tree.Tree("f")
          ),
          tree.Tree("g")
        ),
      )
    )
  )
  test.validate(False,
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
      ),
      tree.Tree("c",
        tree.Tree("b",
          tree.Tree("a")
        ),
        tree.Tree("d",
          tree.Tree("e",
            tree.Tree("f")
          ),
          tree.Tree("g")
        ),
      )
    )
  )

if __name__ == "__main__":
  main()
