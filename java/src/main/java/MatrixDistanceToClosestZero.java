import java.util.LinkedList;

class MatrixDistanceToClosestZero {
  public int[][] updateMatrix(int[][] mat) {
    var queue = new LinkedList<int[]>();
    var dist = new int[mat.length][mat[0].length];

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 0) {
          queue.offer(new int[] { i, j });
        }

        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    while (!queue.isEmpty()) {
      var coord = queue.poll();
      var x = coord[0];
      var y = coord[1];

      if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] == -1) {
        continue;
      } else if (mat[x][y] == 0) {
        dist[x][y] = 0;
      } else {
        var up = x > 0 ? dist[x - 1][y] : Integer.MAX_VALUE;
        var left = y > 0 ? dist[x][y - 1] : Integer.MAX_VALUE;
        var down = x < mat.length - 1 ? dist[x + 1][y] : Integer.MAX_VALUE;
        var right = y < mat[0].length - 1 ? dist[x][y + 1] : Integer.MAX_VALUE;

        dist[x][y] = Math.min(
            Math.min(left, right),
            Math.min(up, down)) + 1;
      }

      mat[x][y] = -1;
      queue.offer(new int[] { x - 1, y });
      queue.offer(new int[] { x, y - 1 });
      queue.offer(new int[] { x + 1, y });
      queue.offer(new int[] { x, y + 1 });
    }

    return dist;
  }
}
/*
 * // Go through matrix and find all 0s
 * // Push them onto a stack
 * // Then go through all the neighbors and push them on stacks if not visited
 * // Repeat until done
 */
