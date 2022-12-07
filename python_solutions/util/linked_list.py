class Node:
  def __init__(self, value, link = None):
    self.value = value
    self.link = link

  def __repr__(self) -> str:
    return f"({self.value}) -> {None if self.link is None else self.link.__repr__()}"

  def __eq__(self, __o: object) -> bool:
    if self.link != __o.link:
      return False

    return self.value == __o.value and self.link.__eq__(__o.link)

def create(*args) -> Node:
  """ Creates a Linked List from an array"""
  head = None

  for index in range(len(args) - 1, -1, -1):
    head = Node(args[index], head)

  print(f"Created: {head}")
  return head
