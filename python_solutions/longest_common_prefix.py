# url: https://leetcode.com/problems/longest-common-prefix/
# difficulty: easy

# Write a function to find the longest common prefix string amongst an array of strings.
# If there is no common prefix, return an empty string "".
#
# Example 1:
#
# Input: strs = ["flower","flow","flight"]
# Output: "fl"

# Example 2:
#
# Input: strs = ["dog","racecar","car"]
# Output: ""
# Explanation: There is no common prefix among the input strings.

from typing import List


def solve(strs: List[str]) -> str:
    if len(strs) == 0 or len(strs[0]) < 1:
        return ""

    prefix = ""
    index = 0

    while True:
        for i in range(0, len(strs)):
            if len(strs[i]) < index or strs[i][index] != strs[0][index]:
                return prefix
        prefix += strs[0][index]
        index += 1

    return prefix
