from typing import List
from python_solutions.util import linked_list


class LRUCache:
    def __init__(self, capacity: int):
        self.items = {}
        self.head = self.tail = None
        self.capacity = capacity
        self.count = 0

    def get_(self, index, node):
        return int(node.value.split(":")[index])

    def push(self, key: int, value: int) -> linked_list.Node:
        node = linked_list.Node(f"{key}:{value}", self.head)
        self.items[key] = node

        if self.tail is None:
            self.tail = node

        if self.head is not None:
            self.head.prev = node

        self.head = node
        self.count += 1
        return node

    def remove(self, key: int) -> linked_list.Node:
        node = self.items[key]
        del self.items[key]

        if self.count == 1:
            self.tail = None
            self.head = None
        else:
            if self.head is node:
                self.head = self.head.link
            if self.tail is node:
                self.tail = self.tail.prev

            if node.prev is not None:
                node.prev.link = node.link
                if node.link is not None:
                    node.link.prev = node.prev
            
        self.count -= 1
        return node

    def get(self, key: int) -> int:
        if key not in self.items:
            return -1

        node = self.remove(key)
        value = self.get_(1, node)
        self.push(key, value)

        return value

    def put(self, key: int, value: int) -> None:
        if key in self.items:
            self.remove(key)
        else:
            if self.count == self.capacity:
                self.remove(self.get_(0, self.tail.link))

        self.push(key, value)


def solve(ops: List[str], values: List[str]):
    pass


# LRU Cache(2)
# put 1, put 2, get 1, put 3, get 2, get 1

# i = {}, 
# h = None
# t = None

# i = {1:1}       # Add 1 to our map
# t = 1           # since t was None, we assign tail to our new node
# h = 1 -> None   # Since h was None, we created a new node that became the head and assigned the old head to next

# i = {1:1, 2:2}  # Add 2 to our map
# t = 1               # Don't move tail 
# r = 2 -> 1 -> None  # Since we're under capacity and the item is not in the list, we add it to the head

# i = {1:1, 2:2}  # No changes
# t = 2               # Since the item was the tail, we move the tail to the previous item
# r = 1 -> 2 -> None  # Since the item is in the list, we remove it from it's place and move it to the front

# i = {1:1, 3:3}  # Since we're at capacity, look up the tail element and remove it from the map
# t = 1               # Since the item was the tail, we move the tail to the previous item
# r = 3 -> 1 -> None  # Remove the tail element from the list and add the new element to the head

