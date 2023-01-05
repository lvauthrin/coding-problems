# url: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
# difficulty: medium

# There is an integer array nums sorted in ascending order (with distinct values).
# 
# Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
# 
# Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
# 
# You must write an algorithm with O(log n) runtime complexity.

from typing import List


def solve(nums: List[int], target: int) -> int:
    start = 0
    end = len(nums) - 1

    while end >= start:
        mid = (start + end) // 2
        print(start, end, mid, nums[mid], target)

        if nums[mid] == target:
            return mid
        elif nums[start] <= nums[mid]:
            if nums[start] <= target <= nums[mid]:
                end = mid - 1
            else:
                start = mid + 1
        else:
            if nums[mid] <= target <= nums[end]:
                start = mid + 1
            else:
                end = mid - 1

    return -1

# [4,5,6,7,0,1,2], 0, 4

#        s m   e
# [4,5,6,7,0,1,2]  - found? no, greater? yes, is end greater? no then go right
#
#          V  
# [4,5,6,7,0,1,2]  - found? no, greater? no, is start greater? no then go left
# 
#  V  
# [4,5,6,7,0,1,2]  - found? no, greater? no, is start greater? no then go left
# 

