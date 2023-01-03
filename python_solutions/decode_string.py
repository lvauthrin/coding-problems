# url: https://leetcode.com/problems/decode-string/
# difficulty: medium

# Given an encoded string, return its decoded string.
# 
# The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
# 
# You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
# 
# The test cases are generated so that the length of the output will never exceed 105.

def solve(s: str) -> str:
    i = 0
    o_stack = [""]
    count_stack = [1]

    while i < len(s):
        if s[i].isalpha():
            o_stack[-1] += s[i]
        elif s[i].isdigit():
            num = ""

            while s[i].isdigit():
                num += s[i]
                i += 1

            o_stack.append("")
            count_stack.append(int(num))
        elif s[i] == "]":
            o = o_stack.pop() * count_stack.pop()
            o_stack[-1] += o

        i += 1

    return o_stack.pop() * count_stack.pop()


# 3[a]2[bc] -- o = "", i = 0, num = 
# ^
#
# 3[a2[c]] -- stack = [""], o = "accaccacc", repeat = 3, [1]
#        ^

