from typing import List


# A Toeplitz Matrix is one where the values on every diagonal are the same.
# Given a 2d matrix (multidimensional array), return true if the input is a Toeplitz matrix and false otherwise.
#
# Example of a valid Toeplitz matrix:
#
# 1 2 3 4
# 5 1 2 3
# 6 5 1 2
# 7 6 5 1
#
def solve(matrix: List[List[int]]) -> bool:
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if i > 0 and j > 0 and matrix[i][j] != matrix[i - 1][j - 1]:
                return False

    return True
