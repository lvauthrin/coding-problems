# url: https://leetcode.com/problems/maximum-subarray/
# difficulty: medium

# Given an integer array nums, find the subarray which has the largest sum and return its sum.
# 
# Example 1:
# 
# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: [4,-1,2,1] has the largest sum = 6.

# Example 2:
# 
# Input: nums = [1]
# Output: 1

# Example 3:
# 
# Input: nums = [5,4,-1,7,8]
# Output: 23

from typing import List


def solve(nums: List[int]) -> int:
    max_sum = cur_sum = float('-inf')

    for e in nums:
        if cur_sum <= 0:
            cur_sum = e
        else:
            cur_sum += e

        max_sum = max(cur_sum, max_sum)

    return max_sum

#                      s
# [-2,1,-3,4,-1,2,1,-5,4]
# [-2 1 -2 4  3,5 6,-1,4] m = 1
