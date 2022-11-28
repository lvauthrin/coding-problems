
class Tree():
  def init(self, value, left = None, right = None):
    self.value = value
    self.left = left
    self.right = right

  def to_string(self):
    left = right = ""
    value = self.value

    if self.left != None:
      left = to_string(self.left)
    if self.right != None:
      right = to_string(self.right)

    return f"{left} {value} {right}"

def main():
  tree1 = Tree("a")
  tree1 = Tree("b", Tree("a"), Tree("c"))

if __name__ == "__main__":
  main()