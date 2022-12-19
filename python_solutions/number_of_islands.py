# url: https://leetcode.com/problems/number-of-islands/
# difficulty: medium
# Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

# An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
# 
# Example 1:
# 
# Input: grid = [
#   ["1","1","1","1","0"],
#   ["1","1","0","1","0"],
#   ["1","1","0","0","0"],
#   ["0","0","0","0","0"]
# ]
# Output: 1

# Example 2:
# 
# Input: grid = [
#   ["1","1","0","0","0"],
#   ["1","1","0","0","0"],
#   ["0","0","1","0","0"],
#   ["0","0","0","1","1"]
# ]
# Output: 3

from typing import List

def visit(grid, i, j):
    if i >= 0 and j >= 0 and i < len(grid) and j < len(grid[i]) and grid[i][j] == "1":
        grid[i][j] = "0"
        visit(grid, i - 1, j)
        visit(grid, i, j - 1)
        visit(grid, i, j + 1)
        visit(grid, i + 1, j)
        return 1
    return 0

def solve(grid: List[List[int]]) -> int:
    islands = 0

    for i in range(len(grid)):
        for j in range(len(grid[i])):
            islands += visit(grid, i, j)

    return islands

#   ["1","1","0","0","0"],
#   ["1","1","0","0","0"],    c: (0,4)
#   ["0","0","1","0","0"],    v: [0,0 0,1 0,2, 1,1 1,2 2,1 1,0 2,0]
#   ["0","0","0","1","1"]
