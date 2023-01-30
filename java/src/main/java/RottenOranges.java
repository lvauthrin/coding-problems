import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class RottenOranges {
  private static class Item {
    public Item(int i, int j, int l) {
      this.i = i;
      this.j = j;
      this.l = l;
    }

    public int i;
    public int j;
    public int l;
  }

  public int orangesRotting(int[][] grid) {
    // Put all rotten orange in a queue
    // Do a BFS and track the level
    // Return the level at the end

    var queue = new LinkedList<Item>();
    var good = new HashSet<String>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new Item(i, j, 0));
        } else if (grid[i][j] == 1) {
          good.add(i + ":" + j);
        }
      }
    }

    var level = 0;

    while (!queue.isEmpty()) {
      var cur = queue.pop();
      grid[cur.i][cur.j] = 0;
      level = Math.max(level, cur.l);

      if (isGood(grid, good, cur.i - 1, cur.j))
        queue.offer(new Item(cur.i - 1, cur.j, cur.l + 1));
      if (isGood(grid, good, cur.i + 1, cur.j))
        queue.offer(new Item(cur.i + 1, cur.j, cur.l + 1));
      if (isGood(grid, good, cur.i, cur.j - 1))
        queue.offer(new Item(cur.i, cur.j - 1, cur.l + 1));
      if (isGood(grid, good, cur.i, cur.j + 1))
        queue.offer(new Item(cur.i, cur.j + 1, cur.l + 1));
    }

    return good.isEmpty() ? level : -1;
  }

  private boolean isGood(int[][] grid, Set<String> good, int i, int j) {
    var fresh = i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;

    if (fresh) {
      grid[i][j] = 0;
      good.remove(i + ":" + j);
    }

    return fresh;
  }
  /*
   * [2,2] queue = (3:0 1:0:1 1:1:1)
   * [1,1] good = (1:0 1:1)
   * [0,0] level = 0
   * [2,0]
   * 
   */
}
