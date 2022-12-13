import sys
import pytest
from python_solutions import candy_crush
from python_solutions.util import test


def test_nominal():
    assert candy_crush.solve("aabbbacd") == "cd"


def test_overlapping():
    assert candy_crush.solve("dddabbbbaccccaax") == "x"


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
