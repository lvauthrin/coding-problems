import sys
import pytest

from python_solutions import is_matrix_monotonic


def test_nominal():
    assert is_matrix_monotonic.solve([[0, 0, 0, 1], [1, 1, 1, 2], [2, 3, 4, 5]]) == True


def test_not_increasing():
    assert is_matrix_monotonic.solve([[0, 0, 0, 1], [1, 1, 3, 2], [2, 3, 4, 5]]) == False


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
