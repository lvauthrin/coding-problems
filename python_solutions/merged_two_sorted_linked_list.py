from util import test
from util import linked_list

class Solution:
  def __init__(self):
    pass

  def solve(self, first, second):
    head = result = linked_list.create(None)

    while first is not None and second is not None:
      if first.value < second.value:
        result.link = linked_list.create(first.value)
        first = first.link
      else:
        result.link = linked_list.create(second.value)
        second = second.link

      result = result.link

    if first is not None:
      result.link = first
    elif second.link is not None:
      result.link = second

    return head.link

def main():
  test.validate(
    linked_list.create(1,2,3,4,5,6,7,8),
    Solution().solve(
      linked_list.create(1,2,7,8),
      linked_list.create(3,4,5,6)
    )
  )
  test.validate(
    linked_list.create(3,4,5,6),
    Solution().solve(
      linked_list.create(),
      linked_list.create(3,4,5,6)
    )
  )
  test.validate(
    linked_list.create(1,2,3,4,5,6,7,8),
    Solution().solve(
      linked_list.create(1,2,3,4),
      linked_list.create(5,6,7,8)
    )
  )

if __name__ == "__main__":
  main()
