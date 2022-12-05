from util import test

class Solution:
  def __init__(self):
    pass

  def solve(self, string):
    stack = [(string[0], 1)]

    for i in range(1, len(string)):
      if stack[-1][0] == string[i]:
        stack[-1] = (stack[-1][0],  stack[-1][1] + 1)
      else:
        count = stack[-1][1]
        if count >= 3:
          stack.pop()

          if stack and stack[-1][0] == string[i]:
            stack[-1] = (stack[-1][0],  stack[-1][1] + 1)
          else:
            stack.append((string[i], 1))
        else:
          stack.append((string[i], 1))

    return ''.join([tuple[0] for tuple in stack])

def main():
  solution = Solution()
  test.timed_validate("cd", solution.solve, "aabbbacd")
  test.timed_validate("x", solution.solve, "dddabbbbaccccaax")

if __name__ == "__main__":
  main()