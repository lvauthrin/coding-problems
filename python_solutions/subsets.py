from util import test


class Solution:
    def __init__(self, tabulate):
        self.tabulate = tabulate

    def solve_tabulate(self, string):
        perms = [""]
        curr_perms = []

        for char in string:
            for item in perms:
                curr_perms.append(char + item)
                curr_perms.append(item)

            perms = curr_perms
            curr_perms = []

        return sorted(perms)

    def solve_recursive(self, string):
        if len(string) == 1:
            return [string, ""]

        perms = []

        for item in self.solve_recursive(string[1:]):
            perms.append(string[0] + item)
            perms.append(item)

        return sorted(perms)

    def solve(self, string):
        if self.tabulate:
            return self.solve_tabulate(string)
        else:
            return self.solve_recursive(string)


def main():
    solution = Solution(True)
    test.timed_validate(["", "a", "b", "ba", "c", "ca", "cb", "cba"], solution.solve, "abc")
    test.timed_validate(
        ["", "1", "2", "21", "3", "31", "32", "321", "4", "41", "42", "421", "43", "431", "432", "4321"],
        solution.solve,
        "1234",
    )


if __name__ == "__main__":
    main()
