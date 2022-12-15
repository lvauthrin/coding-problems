import sys
import pytest

from python_solutions.util import tree
from python_solutions import binary_tree_to_linked_list as sol

data = [
    (
        tree.Tree(
            1,
            tree.Tree(2, tree.Tree(3), tree.Tree(4)),
            tree.Tree(5, None, tree.Tree(6)),
        ),
    ),
]


@pytest.mark.parametrize("first, expected", data)
def test_nominal(first, expected):
    assert sol.solve(first) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
