import sys
import pytest
from python_solutions import add_two_linked_lists
from python_solutions.util import linked_list
from python_solutions.util import test


def test_nominal():
    assert add_two_linked_lists.solve(
        linked_list.create(1, 2, 3, 4),
        linked_list.create(2, 3, 4),
    )== linked_list.create(3, 5, 7, 4)


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
