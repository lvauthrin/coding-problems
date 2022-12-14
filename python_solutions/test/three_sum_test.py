import sys
import pytest
from python_solutions import three_sum


data = [
    ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
    ([0, 1, 1], []),
    ([0, 0, 0], [[0, 0, 0]]),
]


@pytest.mark.parametrize("first, expected", data)
def test_nominal(first, expected):
    assert three_sum.solve(first) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
