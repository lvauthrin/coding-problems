from typing import List


# Given a rectangular 2D array of integers, return true if all rows and all columns are monotonically increasing.
# This means that every successive value along all rows and columns must be AT LEAST as large as what came before.
#
# Example:
#
# [[0, 0, 0, 1],
#  [1, 1, 1, 2],
#  [2, 3, 4, 5]]
#
# Returns true but this next one returns false.
#
# [[0, 0, 0, 1],
#  [1, 1, 3, 2],
#  [2, 3, 4, 5]]
#
def solve(matrix: List[List[int]]):
    if len(matrix) == 0 or len(matrix) == 1:
        return True

    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if i + 1 < len(matrix):
                if matrix[i][j] > matrix[i + 1][j]:
                    return False
            if j + 1 < len(matrix[i]):
                if matrix[i][j] > matrix[i][j + 1]:
                    return False

    return True
