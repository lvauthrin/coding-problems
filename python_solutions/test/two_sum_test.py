import unittest
from python_solutions import two_sum
from python_solutions.util import test

class TestTwoSum(unittest.TestCase):

  def test_nominal(self):
    test.timed_validate([0,1], two_sum.solve, [2,7,11,15], 9)
    test.timed_validate([0,1], two_sum.solve, [3,3], 6)

if __name__ == '__main__':
  unittest.main()

