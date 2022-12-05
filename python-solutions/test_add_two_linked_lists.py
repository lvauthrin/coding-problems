import unittest
from util import linked_list
from util import test
import add_two_linked_lists

class TestAddTwoLinkedLists(unittest.TestCase):

  def test_nominal(self):
    test.timed_validate(
      linked_list.create(3,5,7,4),
      add_two_linked_lists.solve,
      linked_list.create(1,2,3,4),
      linked_list.create(2,3,4)
    )

if __name__ == '__main__':
  unittest.main()
