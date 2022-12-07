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
