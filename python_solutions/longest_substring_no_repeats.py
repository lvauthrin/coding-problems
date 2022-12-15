# url: https://leetcode.com/problems/longest-substring-without-repeating-characters/
# difficulty: medium

# Given a string s, find the length of the longest
# substring without repeating characters.
#
# Example 1:
#
# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.

# Example 2:
#
# Input: s = "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.

# Example 3:
#
# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
# Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


def solve(s: str) -> int:
    start = end = count = current = 0
    seen = {}

    if s is None or len(s) == 0:
        return 0

    while end < len(s):
        end_char = s[end]

        if end_char in seen and seen[end_char] >= start:
            start = seen[end_char] + 1
        else:
            seen[end_char] = end
            end += 1

        current = end - start
        count = max(count, current)

    return count


#
#     s
# b b t a b l u d | count=3, current=3 | seen={b:4,t:2,a:3,l:5}
#               e
#

# None -> 0
# "" -> 0
# "a" -> 1
# "aa" -> 1
# "ab" -> 2
#
# s
# a b c a b c b b  | count=0, current=0 | seen={}
# e
#
# s
# a b c a b c b b  | count=3 | a=0, b=1, c=2
#     e
#
#   s
# a b c a b c b b  | count=3 | a=3, b=1, c=2
#       e
#
#     s
# a b c a b c b b  | count=3 | a=3, b=4, c=2
#         e
#
#       s
# a b c a b c b b  | count=3 | a=3, b=4, c=5
#           e
#
#           s
# a b c a b c b b  | count=3 | a=3, b=6, c=5
#             e
#
#               s
# a b c a b c b b  | count=3 | a=3, b=7, c=5
#               e
