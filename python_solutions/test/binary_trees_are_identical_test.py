import sys
import pytest

from python_solutions.util import tree
from python_solutions import binary_trees_are_identical as sol


data = [
    (tree.Tree("a"), tree.Tree("a"), True),
    (tree.Tree("a"), tree.Tree("b"), False),
    (
        tree.Tree(
            "c",
            tree.Tree("b", tree.Tree("a")),
            tree.Tree("d", tree.Tree("e", tree.Tree("f")), tree.Tree("g")),
        ),
        tree.Tree(
            "c",
            tree.Tree("b", tree.Tree("a")),
            tree.Tree("d", tree.Tree("e", tree.Tree("f")), tree.Tree("g")),
        ),
        True,
    ),
    (
        tree.Tree(
            "c",
            tree.Tree("b", tree.Tree("a")),
            tree.Tree("d", tree.Tree("e", tree.Tree("h")), tree.Tree("g")),
        ),
        tree.Tree(
            "c",
            tree.Tree("b", tree.Tree("a")),
            tree.Tree("d", tree.Tree("e", tree.Tree("f")), tree.Tree("g")),
        ),
        False,
    ),
]


@pytest.mark.parametrize("first, second, expected", data)
def test_nominal(first, second, expected):
    assert sol.solve(first, second) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
