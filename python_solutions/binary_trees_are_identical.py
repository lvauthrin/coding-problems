from python_solutions.util import tree


def solve(first: tree.Tree, second: tree.Tree) -> bool:
    if (first is None and second is not None) or (second is None and first is not None):
        return False
    elif first is None:
        return True

    return first.value == second.value and solve(first.left, second.left) and solve(first.right, second.right)
