import sys
import pytest
from python_solutions import longest_substring_no_repeats as sol


data = [
    ("abcabcbb", 3),
    ("bbbbb", 1),
    ("pwwkew", 3),
]


@pytest.mark.parametrize("first, expected", data)
def test_nominal(first, expected):
    assert sol.solve(first) == expected


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
