import sys
import pytest
from python_solutions import valid_parens
from python_solutions.util import test


def test_nominal():
    assert valid_parens.solve( "[(){}([])]")


def test_not_valid():
    assert not valid_parens.solve( "(})")


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
