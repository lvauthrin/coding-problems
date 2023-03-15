/*
 * Given a rectangular 2D array of integers, return true if all rows and all columns are monotonically increasing.
 * This means that every successive value along all rows and columns must be AT LEAST as large as what came before.
 *
 * Example:
 *
 * [[0, 0, 0, 1],
 *  [1, 1, 1, 2],
 *  [2, 3, 4, 5]]
 *
 * Returns true but this next one returns false.
 *
 * [[0, 0, 0, 1],
 *  [1, 1, 3, 2],
 *  [2, 3, 4, 5]]
 */
class IsMatrixMonotonic {
  public boolean isMonotonic(int[][] matrix) {
    if (matrix.length == 0 || matrix.length == 1)
      return true;

    for (var i = 0; i < matrix.length; i++) {
      for (var j = 0; j < matrix[i].length; j++) {
        if (i + 1 < matrix.length) {
          if (matrix[i][j] > matrix[i + 1][j])
            return false;
        }

        if (j + 1 < matrix[i].length) {
          if (matrix[i][j] > matrix[i][j + 1])
            return false;
        }
      }

    }

    return true;
  }
}
