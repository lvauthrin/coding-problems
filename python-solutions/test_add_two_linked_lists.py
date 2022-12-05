import pytest
from util import test

def test_nominal():
  solution = Solution()

  test.timed_validate(
    linked_list.create(3,5,7,4),
    solution.solve,
    linked_list.create(1,2,3,4),
    linked_list.create(2,3,4)
  )