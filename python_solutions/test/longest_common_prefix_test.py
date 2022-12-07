import unittest
from python_solutions import longest_common_prefix
from python_solutions.util import test

class TestLongestCommonPrefix(unittest.TestCase):

  def test_nominal(self):
    test.timed_validate("fl", longest_common_prefix.solve, ["flower", "flow", "flight"])
    test.timed_validate("", longest_common_prefix.solve, ["dog", "racecar", "car"])

if __name__ == "__main__":
  unittest.main()
