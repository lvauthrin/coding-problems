from python_solutions.util import linked_list

# url: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

# Cases:
# None -> None
#
# 1 -> None
#
# 1 -> 2 -> None
#
# h
# 1 -> 2 -> None
# c


# Two options:
# Single iteration to get the count (*)
# Advance a + 1
# h, p, c, d
#
# h              p    c
# 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> None
def solve(node: linked_list.Node) -> linked_list.Node | None:
    if node is None or node.link is None:
        return None

    head = previous = current = node
    double = node.link

    while double is not None and double.link is not None:
        previous = current
        current = current.link
        double = double.link.link

    if double is None:
        previous.link = current.link
    else:
        current.link = current.link.link

    return head
