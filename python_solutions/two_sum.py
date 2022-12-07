from typing import List

# Edge cases: negative numbers-yes, empty array-sure, nulls-no, duplicates-yes, sorted-no?
# Iterate through array and put value as index and index as value
# Iterate again and check if there exists the difference of target and value in map and if it's not the same index
def solve(nums: List[int], target: int) -> List[int]:
  num_indexes = {}

  for i, v in enumerate(nums):
    complement = target - v

    if complement in num_indexes:
      return [num_indexes[complement], i]

    num_indexes[v] = i

