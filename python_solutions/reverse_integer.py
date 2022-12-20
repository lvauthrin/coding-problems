# url: https://leetcode.com/problems/reverse-integer/
# difficulty: medium

# Given a signed 32-bit integer x, return x with its digits reversed.
# If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
# Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

def solve(x: int) -> int:
    result = 0
    cur = abs(x)
    multiplier = -1 if x < 0 else 1

    while cur > 0:
        mod = cur % 10
        result = result * 10 + mod
        cur = cur // 10

    if result > pow(2, 31):
        return 0

    return result * multiplier

# 12 -> 0000 1100
# 21 -> 0001 0101

# 321 / 10 -> 32, r = 1
# 32 / 10 -> 3, r = 2
# 3 / 10 -> 0, r = 3

# -123 / 10 -> -12, r = -3
# -12 / 10 -> -1, r = -2
# -1 / 10 -> 0, r = -1

# 120 / 10 -> 12, r = 0
# 12 / 10 -> 1, r = 2
# 1 / 10 -> 0, r = 1
