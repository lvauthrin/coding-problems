"""
Link:
"""
from typing import List

class Solution:
  """ solution class """

  def find_number_of_ways(self, x, y):
    """ main_method """

    if x == 0 or y == 0:
        return 0
    if x == 1 and y == 1:
        return 1

    xways = find_number_of_ways(x - 1, y)
    yways = find_number_of_ways(x, y - 1)

    return max(xways, yways)