import unittest
from python_solutions import candy_crush
from python_solutions.util import test

class TestCandyCrush(unittest.TestCase):

  def test_nominal(self):
    test.timed_validate("cd", candy_crush.solve, "aabbbacd")
    test.timed_validate("x", candy_crush.solve, "dddabbbbaccccaax")

if __name__ == '__main__':
  unittest.main()
