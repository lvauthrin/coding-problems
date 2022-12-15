from collections import deque


class ReprType:
    BFS = 1
    IN_ORDER = 2


class Tree:
    def __init__(self, value, left=None, right=None, repr_mode=ReprType.BFS):
        self.value = value
        self.left = left
        self.right = right
        self.repr_mode = repr_mode

    def in_order(self):
        """doc"""
        left = right = ""
        value = self.value

        if self.left is not None:
            left = self.left.in_order()
        if self.right is not None:
            right = self.right.in_order()

        return f"{left} {value} {right}"

    def values_by_level(self):
        stack = deque([(self, 0)])
        values = []

        while len(stack) > 0:
            node, level = stack.pop()
            if level >= len(values):
                values.append([])
            values[level].append(node.value)

            if node.left is not None:
                stack.appendleft((node.left, level + 1))
            if node.right is not None:
                stack.appendleft((node.right, level + 1))

        return values

    # def __repr__(self):
    #  values = self.values_by_level()
    #
    #  for level in range(len(values) - 1, -1, -1):
    #    " ".join(values[level])
    def make_pad_line(self, left, right):
        if len(left) == 0 and len(right) == 0:
            return ""

        padl = len(left) // 2
        padr = len(right) // 2

        left_chars = "" if len(left) == 0 else (" " * padl) + "┌" + ("─" * padl)
        right_chars = "" if len(right) == 0 else ("─" * padr) + "┐" + (" " * padr)
        middle_char = "┴"

        if len(left) == 0:
            middle_char = "└"
        elif len(right) == 0:
            middle_char = "┘"

        return f"{left_chars}{middle_char}{right_chars}"

    def format(self):
        left = [] if self.left is None else self.left.format()
        right = [] if self.right is None else self.right.format()
        merged = [self.make_pad_line("" if len(left) == 0 else left[0], "" if len(right) == 0 else right[0])]

        for i in range(0, max(len(left), len(right))):
            merged.append(f"{'' if i >= len(left) else left[i]} {'' if i >= len(right) else right[i]}")

        # max_length = 0
        # for line in merged:
        #  max_length = max(len(line), max_length)

        left_half = len(left) - len(str(self.value)) // 2
        right_half = len(left) + len(right) + 1 - (left_half + 1 + len(str(self.value)) // 2)

        new_merged = [f"{' ' * left_half}{self.value}{' ' * right_half}"]
        new_merged.extend(merged)
        return new_merged

        # left_pad = left
        #  if left is None and right is None:
        #   return [f"{self.value}"]
        #  return [
        #   f"{' ' * len(left[0])}{self.value}{' ' * len(right[0])}",
        #  ]

    def __repr__(self) -> str:
        return "\n".join(self.format())

    def __eq__(self, __o: object) -> bool:
        if __o is None:
            return False

        return self.value == __o.value and self.left.__eq__(__o.left) and self.right.__eq__(__o.right)


if __name__ == "__main__":
    # print(Tree(None).make_pad_line("abc", "a"))
    # print("abc a")
    # print(Tree(None).make_pad_line("a", "abc"))
    # print("a abc")
    # print(Tree(None).make_pad_line("abc", "abc"))
    # print("abc abc")
    # print(Tree(None).make_pad_line("", "abc"))
    # print(" abc")
    # print(Tree(None).make_pad_line("abc", ""))
    #  print("abc")
    # print(Tree(None).make_pad_line("a", ""))
    #  print("a")
    # print(Tree(None).make_pad_line("", "a"))
    # print(" a")

    print(
        Tree(
            "a",
            Tree(
                "b",
                None,  # Tree("d"),
                Tree("e"),
            ),
            Tree("c", Tree("f"), Tree("g")),
        )
    )
