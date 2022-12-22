# url: https://leetcode.com/problems/valid-sudoku/
# difficulty: medium

# Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
#
# Each row must contain the digits 1-9 without repetition.
# Each column must contain the digits 1-9 without repetition.
# Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
# Note:
#
# A Sudoku board (partially filled) could be valid but is not necessarily solvable.
# Only the filled cells need to be validated according to the mentioned rules.
#

from typing import List


def solve(board: List[List[int]]) -> bool:
    cols = [{} for i in range(len(board))]
    rows = [{} for i in range(len(board))]
    squares = [{} for i in range(len(board))]

    for i in range(len(board)):
        for j in range(len(board[i])):
            value = board[i][j]

            if value == ".":
                continue

            if value in rows[i] or value in cols[j]:
                print(rows, cols, squares)
                return False

            square_index = (i // 3 * 3) + j // 3

            if value in squares[square_index]:
                print(i, j, square_index, rows, cols, squares)
                return False

            rows[i][value] = value
            cols[j][value] = value
            squares[square_index][value] = value

    return True
