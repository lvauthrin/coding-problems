import sys
import pytest

from python_solutions import toeplitz_matrix


def test_nominal():
    assert toeplitz_matrix.solve(
        [
            [1, 2, 3, 4],
            [5, 1, 2, 3],
            [6, 5, 1, 2],
            [7, 6, 5, 1],
        ]
    )


def test_not_increasing():
    assert not toeplitz_matrix.solve([[0, 0, 0, 1], [1, 1, 3, 2], [2, 3, 4, 5]])


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
