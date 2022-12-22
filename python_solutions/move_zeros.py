# url: https://leetcode.com/problems/move-zeroes/
# difficulty: easy

# Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
#
# Note that you must do this in-place without making a copy of the array.

from typing import List


def solve(nums: List[int]) -> List[int]:
    w = r = 0

    while r < len(nums) and w < len(nums):
        if nums[w] != 0:
            w += 1
        elif nums[r] != 0 and w < r:
            nums[w], nums[r] = nums[r], nums[w]
            r += 1
        else:
            r += 1

    return nums


#             r
# [1,3,0,0,12]
#      w
#
#  r
# [0,1,0,3,12] # is w on a zero?  no then move forward r and w forward until we get to a zero, if yes, then move r forward
#  w 
#
#    r
# [0,1,0,3,12] # is r on a zero? yes and if w < r then copy r[i] to w[i] and move w forward until it arrives at a zero
#  w
#
#    r
# [1,0,0,3,12]
#    w
#
#      r
# [1,0,0,3,12]
#    w
#
#        r
# [1,0,0,3,12]
#    w
#
#        r
# [1,3,0,0,12]
#      w
#
#             r
# [1,3,12,0,0]
#         w
#
# [1,3,12,0,0]
