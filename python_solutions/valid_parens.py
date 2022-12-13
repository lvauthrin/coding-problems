def solve(string: str) -> bool:
    stack = []
    open = {
        "(": 1,
        "{": 1,
        "[": 1,
    }

    close = {
        ")": "(",
        "}": "{",
        "]": "[",
    }

    for char in string:
        if char in open:
            stack.append(char)
        elif char in close:
            if len(stack) == 0 or stack[-1] != close[char]:
                return False
            stack.pop()

    return len(stack) == 0
