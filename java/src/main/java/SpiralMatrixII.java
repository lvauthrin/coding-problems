class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    var count = 1;
    int xs = 0, ys = 0, xe = n - 1, ye = n - 1;

    while (count <= matrix.length * matrix[0].length) {
      for (int i = ys; i <= ye; i++)
        matrix[xs][i] = count++;
      for (int i = xs + 1; i <= xe; i++)
        matrix[i][ye] = count++;
      for (int i = ye - 1; i >= ys && xs <= xe; i--)
        matrix[xe][i] = count++;
      for (int i = xe - 1; i > xs && ys <= ye; i--)
        matrix[i][ys] = count++;
      xs++;
      ys++;
      xe--;
      ye--;
    }

    return matrix;
  }
}
