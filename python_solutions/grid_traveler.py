"""
Link:
"""


class Solution:
    """solution class"""

    def find_number_of_ways(self, row, col, memo):
        """main_method"""
        key = row + "," + col
        if key in memo:
            return memo[key]

        if row == 0 or col == 0:
            return 0
        if row == 1 and col == 1:
            return 1

        xways = self.find_number_of_ways(row - 1, col, memo)
        yways = self.find_number_of_ways(row, col - 1, memo)

        memo[key] = xways + yways
        return memo[key]