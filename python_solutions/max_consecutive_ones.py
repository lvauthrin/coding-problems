"""
Leetcode: https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
"""

from typing import List


class Solution:  # pylint: disable=too-few-public-methods
    """solution class"""

    def max_consecutive_ones(self, nums: List[int]) -> int:
        """main_method"""
        max_ones = 0
        counter = 0

        for vals in nums:
            if vals == 1:
                counter += 1
                max_ones = max(counter, max_ones)
            else:
                counter = 0

        return max_ones
