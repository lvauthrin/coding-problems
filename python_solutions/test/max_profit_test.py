import unittest
from python_solutions import max_profit
from python_solutions.util import test

class TestMaxProfit(unittest.TestCase):

  def test_nominal(self):
    test.timed_validate(5, max_profit.solve, [7,1,5,3,6,4])
    test.timed_validate(0, max_profit.solve, [7,6,4,3,1])
    test.timed_validate(1, max_profit.solve, [1,2])

if __name__ == '__main__':
  unittest.main()

