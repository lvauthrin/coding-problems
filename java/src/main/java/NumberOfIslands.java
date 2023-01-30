class NumberOfIslands {
  public void numIslands(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
      return;
    if (grid[i][j] != '1')
      return;

    grid[i][j] = '0';

    numIslands(grid, i + 1, j);
    numIslands(grid, i, j + 1);
    numIslands(grid, i - 1, j);
    numIslands(grid, i, j - 1);
  }

  public int numIslands(char[][] grid) {
    var total = 0;
    // Approach:
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          total++;
          numIslands(grid, i, j);
        }
      }
    }

    return total;
  }
}

/*
 * ["1","1","1"],
 * ["0","1","0"],
 * ["1","1","1"]
 */
