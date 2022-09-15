"""
Link: https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2296
"""

class Solution:
  """ solution class """

  def find_number_of_ways(self, target, nums, answers = [], memo = {}):
    """ main_method """
    key = target

    if key in memo:
      return memo[target]

    if target < 0:
        return 0

    if target == 0:
        return 1

    total = 0

    for num in nums:
      candidates = answers
      candidates.append(num)
      total = total + find_number_of_ways(self, target - num, nums, candidates, memo)

    memo[target] = total
    return total

def __main__():
  print("test")