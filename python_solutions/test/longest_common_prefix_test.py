import sys
import pytest
from python_solutions import longest_common_prefix
from python_solutions.util import test


def test_nominal():
    assert longest_common_prefix.solve( ["flower", "flow", "flight"])=="fl"

def test_none():
    assert longest_common_prefix.solve( ["dog", "racecar", "car"])   ==  "" 


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
