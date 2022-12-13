from util import test


class Solution:
    """doc"""

    def __init__(self):
        pass

    def two_sum(self, sum_to, values, i):
        left = i
        right = len(values) - 1

        while left < right:
            total = values[left] + values[right]

            if total == sum_to:
                return True
            elif total < sum_to:
                left += 1
            else:
                right -= 1

        return False

    def solve(self, sum_to, values):
        if len(values) == 0:
            return False
        if len(values) == 1:
            return values[0] == sum_to
        if len(values) == 2:
            return values[0] + values[1] == sum_to

        values.sort()

        for index, value in enumerate(values):
            if self.two_sum(sum_to - value, values, index + 1):
                return True

        return False


def main():
    """doc"""
    test.validate(True, Solution().solve(33, [11, 11, 11]))
    test.validate(True, Solution().solve(10, [1, 2, 3, 4, 5, 6]))
    test.validate(False, Solution().solve(10, [1, 2, 6]))
    test.validate(False, Solution().solve(10, []))
    test.validate(True, Solution().solve(10, [10]))
    test.validate(False, Solution().solve(10, [9]))
    test.validate(False, Solution().solve(10, [0, 5]))
    test.validate(True, Solution().solve(10, [5, 5]))


if __name__ == "__main__":
    main()
