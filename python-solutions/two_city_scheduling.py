from util import test

class Solution:
  def __init__(self):
    pass

  def solve(self, costs: list[list[int]]) -> int:
    costs = sorted(costs, key=lambda cost: cost[0]-cost[1])
    return sum(cost[0] for cost in costs[:len(costs)//2]) + sum(cost[1] for cost in costs[len(costs)//2:])

def main():
  solution = Solution()
  test.timed_validate(18, solution.solve, [[100,2],[3,4],[5,6],[7,99]])

if __name__ == "__main__":
  main()