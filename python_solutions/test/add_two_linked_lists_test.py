import sys
import pytest
from python_solutions import add_two_linked_lists
from python_solutions.util import linked_list


data = [
    tuple(linked_list.create(*x) for x in [[1, 2, 3], [2, 3, 4], [3, 5, 7]]),
    tuple(linked_list.create(*x) for x in [[1, 2, 3, 4], [2, 3, 4], [3, 5, 7, 4]]),
    tuple(linked_list.create(*x) for x in [[9, 9, 9], [9, 9, 9], [8, 9, 9, 1]]),
]


@pytest.mark.parametrize("first, second, expected", data)
def test_nominal(first, second, expected):
    assert add_two_linked_lists.solve(first, second) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
