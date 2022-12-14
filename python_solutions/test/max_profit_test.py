import sys
import pytest
from python_solutions import max_profit

data = [
    ([7, 1, 5, 3, 6, 4], 5),
    ([7, 6, 4, 3, 1], 0),
    ([1, 2], 1),
]


@pytest.mark.parametrize("first, expected", data)
def test_nominal(first, expected):
    assert max_profit.solve(first) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
