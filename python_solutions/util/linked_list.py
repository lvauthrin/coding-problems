class Node:
    def __init__(self, value, link=None, prev=None):
        self.value = value
        self.link = link
        self.prev = prev

    def __repr__(self) -> str:
        if self.link is None:
            return f"({self.value}) -> None"
        else:
            return f"({self.value}) {'<->' if self.link.prev == self else '->'} {self.link.__repr__()}"

    def __eq__(self, __o: object) -> bool:
        if __o is None:
            return False

        return self.value == __o.value and self.link.__eq__(__o.link)


def create(*args) -> Node:
    """Creates a Linked List from an array"""
    head = None

    for index in range(len(args) - 1, -1, -1):
        prev = head
        head = Node(args[index], head)
        if prev is not None:
            prev.prev = head

    return head
