class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i == grid.length || j == grid[i].length)
      return 0;
    if (grid[i][j] == 0)
      return 0;

    grid[i][j] = 0;

    return 1 +
        maxAreaOfIsland(grid, i + 1, j) +
        maxAreaOfIsland(grid, i, j + 1) +
        maxAreaOfIsland(grid, i - 1, j) +
        maxAreaOfIsland(grid, i, j - 1);
  }

  public int maxAreaOfIsland(int[][] grid) {
    var maxArea = 0;

    for (var i = 0; i < grid.length; i++) {
      for (var j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          var area = maxAreaOfIsland(grid, i, j);
          System.out.println(i + " " + j + " " + area);
          maxArea = Math.max(maxArea, area);
        }
      }
    }

    return maxArea;
  }
}
