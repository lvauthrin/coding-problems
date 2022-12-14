import sys
import pytest
from python_solutions import two_sum

data = [
    ([2, 7, 11, 15], 9, [0, 1]),
    ([3, 2, 4], 6, [1, 2]),
    ([3, 3], 6, [0, 1]),
]


@pytest.mark.parametrize("first, second, expected", data)
def test_nominal(first, second, expected):
    assert two_sum.solve(first, second) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
