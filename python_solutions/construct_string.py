"""
Link: https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2296
"""


class Solution:
    """solution class"""

    def can_construct(self, target, substrings, memo):
        # [ 0  1  2  3  4  5  6  ]
        # [ T, F, F, F, F, F, F, ]
        # [ 0  a  b  c  d  e  f  ]

        solution = [True, *[False for i in range(len(target))]]
        print(solution)

        for i, v in enumerate(solution):
            if solution[i]:
                for substring in substrings:
                    print(target[i : i + len(substring)] + " " + substring)
                    if target[i : i + len(substring)] == substring:
                        solution[i + len(substring)] = True

        print(solution)
        return solution[len(target)]

    def count_construct(self, target, substrings, memo):
        solution = [1, *[0 for i in range(len(target) + 1)]]
        print(solution)

        for i, v in enumerate(solution):
            for substring in substrings:
                print(target[i : i + len(substring)] + " " + substring)
                if target[i : i + len(substring)] == substring:
                    solution[i + len(substring)] += solution[i]

        print(solution)
        return solution[len(target)]

    def construct_all(self, target, substrings, memo):
        solutions = [[[]], *[None for i in range(len(target))]]
        print(solutions)

        for i, v in enumerate(solutions):
            for substring in substrings:
                if target[i : i + len(substring)] == substring:
                    for solution in solutions[i]:
                        if solutions[i + len(substring)] is None:
                            solutions[i + len(substring)] = []
                        solutions[i + len(substring)] += [solution + [substring]]
        # [
        #    0 []
        #  a 1 None
        #  b 2 ['ab']
        #  c 3 ['abc']
        #  d 4 ['ab']
        # ]

        print(solutions)
        return solutions[len(target)]


def main():
    solution = Solution()
    assert solution.can_construct("", ["ab", "c", "d", "ef"], {}), "retuned false when expected true"
    assert solution.can_construct("abcdef", ["ab", "c", "d", "ef"], {}), "retuned false when expected true"
    assert not solution.can_construct("abcdef", ["ab", "d", "ef"], {}), "retuned true when expected false"

    assert solution.count_construct("", ["ab", "c", "d", "ef"], {}) == 1, "retuned number other than 1"
    assert solution.count_construct("abcdef", ["ab", "c", "d", "ef"], {}) == 1, "retuned number other than 1"
    assert solution.count_construct("abcdef", ["a", "ab", "bcd", "cd", "ef"], {}) == 2, "retuned number other than 2"

    assert solution.construct_all("", ["ab", "c", "d", "ef"], {}) == [[]], "retuned incorrect solution"
    assert solution.construct_all("abcdef", ["ab", "c", "d", "ef"], {}) == [
        ["ab", "c", "d", "ef"]
    ], "retuned number other than 1"
    assert solution.construct_all("abcdef", ["a", "ab", "bcd", "cd", "ef"], {}) == [
        ["a", "bcd", "ef"],
        ["ab", "cd", "ef"],
    ], "retuned number other than 2"


if __name__ == "__main__":
    main()
    print("main completed")
