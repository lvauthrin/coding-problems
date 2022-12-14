# url: https://leetcode.com/problems/3sum/
# difficulty: medium

# Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
# Notice that the solution set must not contain duplicate triplets.
#
# Example 1:
#
# Input: nums = [-1,0,1,2,-1,-4]
# Output: [[-1,-1,2],[-1,0,1]]
# Explanation:
# nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
# nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
# nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
# The distinct triplets are [-1,0,1] and [-1,-1,2].
# Notice that the order of the output and the order of the triplets does not matter.

# Example 2:
#
# Input: nums = [0,1,1]
# Output: []
# Explanation: The only possible triplet does not sum up to 0.

# Example 3:
#
# Input: nums = [0,0,0]
# Output: [[0,0,0]]
# Explanation: The only possible triplet sums up to 0.

from typing import List


def solve(values: List[int]) -> List[List[int]]:
    values = sorted(values)
    answers = set()

    for i in range(len(values) - 2):
        if values[i] > 0:
            break
        j = i + 1
        k = len(values) - 1
        a = values[i]

        while j < k:
            b = values[j]
            c = values[k]
            total = a + b + c

            if total == 0:
                answers.add(tuple(sorted([a, b, c])))
                k -= 1
            elif total > 0:
                k -= 1
            else:
                j += 1

    return sorted(list(answer) for answer in answers)


# [-1,0,1,2,-1,-4]
# [-4 -1 -1 0 1 2]
#
#   V
# [-4 -1 -1 0 1 2]  -4 + 2 + any(2)?
#               ^
#      V
# [-4 -1 -1 0 1 2]  -1 + 2 + any(-1)? -> [-1, -1, 2]
#               ^
#         V
# [-4 -1 -1 0 1 2]  -1 + 2 + any(-1)? -> dupe         #      V
#               ^                                     # [-4 -1 -1 0 1 2]  -1 + 1 + any(0)? -> [1, -1, 0]
#           V                                         #             ^
# [-4 -1 -1 0 1 2]  2 + 0 + any(-2)?                  #      V
#               ^                                     # [-4 -1 -1 0 1 2]  -1 + 0 + any(1)?  -> dupe
#           V                                         #           ^
# [-4 -1 -1 0 1 2]  1 + 0 + any(-1)? -> [0, 1, -1]    #         V
#             ^                                       # [-4 -1 -1 0 1 2]  1 + 0 + any(-1)? -> [0, 1, -1]
#           ^
