from typing import List


def solve(matrix: List[List[int]]):
    # left = top = 0
    # bottom = len(matrix) - 1
    # right = len(matrix[0]) - 1
    result = ""

    # for i in range(bottom * right):
    #    for j in range(left, right):
    #        result += matrix[i][j]
    #    right -= 1

    #    for j in range(top, bottom):
    #        result += matrix[i][j]
    #    bottom -= 1

    #    for j in range(right, left, -1):
    #        result += matrix[i][j]

    #    for j in range(bottom, top, -1):
    #        result += matrix[i][j]

    return result
