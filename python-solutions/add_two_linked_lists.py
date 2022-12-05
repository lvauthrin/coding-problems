from util import test
from util import linked_list

class Solution:
  def __init__(self):
    pass

  def solve(self, first, second):
    head = result = linked_list.create(None)
    carry = 0
    head_first = first
    head_second = second

    while head_first is not None or head_second is not None:
      first = second = 0

      if head_first is None:
        second = head_second.value
        head_second = head_second.link
      elif head_second is None:
        first = head_first.value
        head_first = head_first.link
      else:
        first = head_first.value
        second = head_second.value
        head_first = head_first.link
        head_second = head_second.link

      total = (carry + first + second) % 10
      carry = (carry + first + second) // 10
      result.link = linked_list.Node(total)
      result = result.link

    return head.link

def main():
  test.validate(
    linked_list.create(3,5,7,4),
    Solution().solve(
      linked_list.create(1,2,3,4),
      linked_list.create(2,3,4)
    )
  )

if __name__ == "__main__":
  main()
