from util import test

# There's a staircase with N steps, and you can climb 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
#
# For example, if N is 4, then there are 5 unique ways:
#
# 1, 1, 1, 1
# 2, 1, 1
# 1, 2, 1
# 1, 1, 2
# 2, 2
# 1, 3
# 3, 1
#
# What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.

# So at each step we have a choice to go for 1 or 2 steps (or n steps).  We can explore that tree.

# N

class Solution:
  def __init__(self, tabulate: bool):
    self.tabulate = tabulate

  def solve_tabulation(self, incr: int, n: int) -> int:
    if n <= 0:
      return 0
    if 1 >= n >= 2:
      return n

    ways = ([1] * incr) + ([0] * (n - incr))

    for i in range(0, n - 1):
      for j in range(1, incr + 1):
        if i+j <= n - 1:
          ways[i + j] += ways[i]

    return ways[-1]

  def solve_recursion(self, curr: int, incr: int, n: int, explored: dict) -> int:
    if curr in explored:
      return explored[curr]
    if curr > n:
      return 0
    if curr == n:
      return 1

    ways = 0

    for i in range(1, incr + 1):
      ways += self.solve_recursion(curr + i, incr, n, explored)

    explored[curr] = ways
    return ways

  def solve(self, incr: int, n: int) -> int:
    if self.tabulate: 
      return self.solve_tabulation(incr, n)
    else:
      return self.solve_recursion(0, incr, n, {})

def main():
  solution = Solution(True)
  test.timed_validate(5, solution.solve, 2, 4)
  test.timed_validate(7, solution.solve, 3, 4)
  test.timed_validate(5, solution.solve, 2, 4)
  test.timed_validate(89, solution.solve, 2, 10)

if __name__ == "__main__":
  main()
