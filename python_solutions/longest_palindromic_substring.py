# url: https://leetcode.com/problems/longest-palindromic-substring/
# difficulty: medium

# Given a string s, return the longest#palindromic substring in s.

def solve(s: str) -> str:
    values = [[0 for j in range(len(s))] for i in range(len(s))]
    largest = 1
    pal = s[0]

    for i in range(0, len(s)):
        for j in range(0, len(s) - i):
            x = j
            y = i + j

            if x == y:
                values[x][y] = 1
            elif y-x == 1 and s[x] == s[y]:
                values[x][y] = 2
            elif s[x] == s[y] and y > 0 and x < (len(s) - 1):
                prev = values[x+1][y-1]

                if prev > 0:
                    values[x][y] = prev + 2

            if values[x][y] > largest:
                largest = y-x + 1
                pal = s[x:y+1]

    return pal

# ""
# a       -> a
# ab      -> a
# bb      -> b
# babacab -> bacab
# bacbac  -> b


# V
# ""
# "" b
# "" b a ba
# "" b a ba b b a ba
# a ba
# b ab 


