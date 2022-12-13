def solve(string):
    stack = [(string[0], 1)]

    for i in range(1, len(string)):
        if stack[-1][0] == string[i]:
            stack[-1] = (stack[-1][0], stack[-1][1] + 1)
        else:
            count = stack[-1][1]
            if count >= 3:
                stack.pop()

                if stack and stack[-1][0] == string[i]:
                    stack[-1] = (stack[-1][0], stack[-1][1] + 1)
                else:
                    stack.append((string[i], 1))
            else:
                stack.append((string[i], 1))

    return "".join([tuple[0] for tuple in stack])
