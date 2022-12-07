from python_solutions.util import linked_list

def solve(first, second):
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

