# url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
# difficulty: easy

# You are given an array prices where prices[i] is the price of a given stock on the ith day.
# You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
# Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
#
# Example 1:
#
# Input: prices = [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
# Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

# Example 2:
#
# Input: prices = [7,6,4,3,1]
# Output: 0
# Explanation: In this case, no transactions are done and the max profit = 0.

from typing import List


def solve(prices: List[int]) -> int:
    if 0 <= len(prices) <= 1:
        return 0

    min_index = 0
    cur_min = prices[min_index]
    cur_max = 0

    for i in range(1, len(prices)):
        if prices[i] <= cur_min:
            min_index = i
            cur_min = prices[min_index]
        else:
            diff = prices[i] - cur_min

            if diff > cur_max:
                cur_max = diff

    return cur_max


# Keep track of cur_min, if we ever drop below that then we reset
# Otherwise, we get the max difference between cur value and cur_min
#
#
# [7,1,5,3,6,4]
# cur_min = 0
# max_diff = 0
#
#  V
# [7,1,5,3,6,4]
# cur_min = 7
# max_diff = 0
#
#    V
# [7,1,5,3,6,4]
# cur_min = 1
# max_diff = 0
#
#      V
# [7,1,5,3,6,4]
# cur_min = 1
# max_diff = 4
#
#        V
# [7,1,5,3,6,4]
# cur_min = 1
# max_diff = 4, index_max = 2
#
#          V
# [7,1,5,3,6,4]
# cur_min = 1, index_min = 2
# max_diff = 5, index_max = 4
#
#            V
# [7,1,5,3,6,4]
# cur_min = 1, index_min = 2
# max_diff = 5, index_max = 4
