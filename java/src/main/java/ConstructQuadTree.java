class ConstructQuadTree {
  // Definition for a QuadTree node.
  public static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  };

  public Node construct(int[][] grid, int x, int y, int size) {
    if (size == 1)
      return new Node(grid[x][y] == 1, true);

    var nextSize = size / 2;

    var topleft = construct(grid, x, y, nextSize);
    var topright = construct(grid, x, y + nextSize, nextSize);
    var bottomleft = construct(grid, x + nextSize, y, nextSize);
    var bottomright = construct(grid, x + nextSize, y + nextSize, nextSize);

    var allLeaves = topleft.isLeaf && topright.isLeaf && bottomleft.isLeaf && bottomright.isLeaf;
    var allTrue = topleft.val && topright.val && bottomleft.val && bottomright.val;
    var allFalse = !(topleft.val || topright.val || bottomleft.val || bottomright.val);

    return allLeaves && (allTrue || allFalse) ? new Node(allTrue, true)
        : new Node(false, false, topleft, topright, bottomleft, bottomright);
  }

  public Node construct(int[][] grid) {
    return construct(grid, 0, 0, grid.length);
  }
}






