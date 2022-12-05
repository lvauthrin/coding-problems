"""
Link: https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2296
"""

class Solution:
  """ solution class """

  def can_sum_to(self, target, nums, memo):
    """ main_method """
    key = target

    if key in memo:
      return memo[target]

    if target < 0:
      return False

    if target == 0:
      return True

    for num in nums:
      if self.can_sum_to(target - num, nums, memo):
        memo[target] = True
        return memo[target]

    memo[target] = False
    return memo[target]

  def find_number_of_ways(self, target, nums, answers, memo):
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
      total = total + self.find_number_of_ways(target - num, nums, candidates, memo)

    memo[target] = total
    return total

def main():
  solution = Solution()
  assert solution.can_sum_to(7, [4,5,7,3], {}), "retuned false when expected true"
  assert solution.can_sum_to(8, [2,3,5], {}), "retuned false when expected true"
  assert not solution.can_sum_to(13, [2,12,4], {}), "retuned true when expected false"

if __name__ == "__main__":
  main()
  print("main completed")