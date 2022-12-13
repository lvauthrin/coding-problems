import sys
import pytest
from python_solutions import max_profit
from python_solutions.util import test


def test_nominal():
    assert max_profit.solve( [7, 1, 5, 3, 6, 4])== 5 

def test_no_profit():
    assert max_profit.solve( [7, 6, 4, 3, 1])   == 0 

def test_minimal():
    assert max_profit.solve( [1, 2])            == 1 


if __name__ == "__main__":
    sys.exit(pytest.main([__file__, "--color=yes"]))
