# url: https://leetcode.com/problems/product-of-array-except-self/
# difficulty: medium

# Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
#
# The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
# 
# You must write an algorithm that runs in O(n) time and without using the division operation.

import math
from typing import List

def solve(nums: List[int]) -> List[int]:
    answer = [0] * len(nums)
    answer[0] = 1

    for i in range(1, len(nums)):
        answer[i] = answer[i-1] * nums[i-1]

    acc = nums[-1]

    for i in range(1, len(nums), 1):
        answer[-i - 1] = acc * answer[-i - 1]
        acc *= nums[-i - 1]

    return answer



# [-1,  1,  0, -3,  3]
# [ 1, -1, -1,  0,  0]
# [ 0,  0, -9,  3,  1]


# [-1, -1 , -1, -3, 3]
# [-1, -1 , -1, 3, 9]
# [-1, -1 , -1, 3, 9]
#
# nums = 1
#                 V
# [-1,  1,  0, 0, 0] acc=9, rev_acc=-9


  
# [-1,  1,  0, -3,  3]
# [ 1, -1, -1,  0,  0]
# [ 0,  0, -9,  3,  1]
# [ 0, -1, -1,  0,  0]
# 
# [ 1, 2, 3, 4]
# [ 1, 1, 2, 6]
# [ 24, 12, 8, 6] acc=24
# [24,12, 4, 1]
# [24,12, 8, 6]
