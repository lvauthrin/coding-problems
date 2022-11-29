from util import test

class Solution:
  def __init__(self):
    pass

  def overlap(self, range_a, range_b):
    max_of_mins = max(range_a[0], range_b[0])
    min_of_maxes = min(range_a[1], range_b[1])

    if max_of_mins <= min_of_maxes:
      return [[min(range_a[0], range_b[0]), max(range_a[1], range_b[1])]]
    else:
      return [range_a, range_b]

  def solve(self, lists):
    merged_lists = [lists[0]]
    cur_index = 0

    for i in range(1, len(lists)):
      result = self.overlap(merged_lists[cur_index], lists[i])

      if len(result) == 1:
        merged_lists[cur_index] = result[0]
      else:
        cur_index += 1
        merged_lists.append(lists[i])

    return merged_lists

def main():
  test.validate([[1,4], [5,10]], Solution().solve([[1,2], [1,4], [5,10]]))
  test.validate([[1,4], [5,10]], Solution().solve([[1,2], [1,4], [5,10], [6,9]]))
  test.validate([[1,4], [5,10]], Solution().solve([[1,2], [1,4], [5,10], [6,9], [7,8]]))
  test.validate([[1,2], [3,4], [5,9]], Solution().solve([[1,2], [3,4], [5,6], [6,9], [7,8]]))

if __name__ == "__main__":
  main()
