# url: https://leetcode.com/problems/two-sum
# difficulty: easy

# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.
#
# Example 1:
# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

# Example 2:
# Input: nums = [3,2,4], target = 6
# Output: [1,2]

# Example 3:
# Input: nums = [3,3], target = 6
# Output: [0,1]

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

    return []
