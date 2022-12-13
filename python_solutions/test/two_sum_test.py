import sys
import pytest
from python_solutions import two_sum
from python_solutions.util import test


def test_nominal():
    assert two_sum.solve( [2, 7, 11, 15], 9 )== [0, 1]

def test_small():
    assert two_sum.solve( [3, 3], 6)==[0, 1]


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
