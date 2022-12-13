import sys
import pytest
from python_solutions import delete_middle_node_linked_list
from python_solutions.util import linked_list
from python_solutions.util import test


def test_odd_size():
    assert delete_middle_node_linked_list.solve(
        linked_list.create(1, 3, 4, 7, 1, 2, 6),
    ) == linked_list.create(1, 3, 4, 1, 2, 6)
        

def test_even_size():
    assert delete_middle_node_linked_list.solve(
        linked_list.create(1, 2, 3, 4),
    ) == linked_list.create(1, 2, 4)
        

if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
