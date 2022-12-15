import sys
import pytest

from python_solutions import maximum_subarray as sol


data = [
    ([-2, 1, -3, 4, -1, 2, 1, -5, 4], 6),
    ([1], 1),
    ([5, 4, -1, 7, 8], 23),
]


@pytest.mark.parametrize("first, expected", data)
def test_nominal(first, expected):
    assert sol.solve(first) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
