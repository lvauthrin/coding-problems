# url: https://leetcode.com/problems/happy-number/
# difficulty: easy

# Write an algorithm to determine if a number n is happy.

# A happy number is a number defined by the following process:
# 
# Starting with any positive integer, replace the number by the sum of the squares of its digits.
# Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
# Those numbers for which this process ends in 1 are happy.
# Return true if n is a happy number, and false if not.
#

def solve(n: int) -> bool:
    sums = {}
    cur = n

    while cur != 1:
        sum = 0
        for e in str(cur):
            int_e = int(e)
            sum += pow(int_e, 2)
        cur = sum

        print(sums)
        if cur in sums:
            return False

        sums[cur] = cur

    return True


# 10000
# 00010
# 00001

#2 -> 4 -> 16 -> 37 -> 58 -> (25 + 64) 89 -> (64 + 81) 145 -> 1 + 16 + 25 -> 42 -> 16 + 4 -> 20 -> 


# 2 -- sums = {}
# 4 -- sums = {4}
# 16 -- sums = {4, 16}
# 1+36 -- sums = {4, 16, 37}
# 9 + 49 -- sums = {4, 16, 37, 58}
# 25 + 64 -- sums = {4, 16, 37, 58, 89}
# 64 + 81 -- sums = {4, 16, 37, 58, 145}
# 1 + 16 + 25 -- sums = {4, 16, 37, 42, 58, 145}
# 16 + 4 -- sums = {4, 16, 20, 37, 42, 58, 145}
# 4+ 0 -- sums = {4, 16, 20, 37, 42, 58, 145}
# 19 -> 82 -> 68 -> 36 + 64 -> 100
