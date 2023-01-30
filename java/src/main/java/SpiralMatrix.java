import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    int xs = 0, ys = 0;
    int xe = matrix.length - 1, ye = matrix[0].length - 1;
    var ans = new ArrayList<Integer>();

    // xs=2,ys=1,xe=1,ye=2 ans = [1,2,3,8,12,11,10,9,5,6,7]

    while (xs <= xe && ys <= ye) {
      for (int i = ys; i <= ye; i++)
        ans.add(matrix[xs][i]);
      xs++;
      for (int i = xs; i <= xe; i++)
        ans.add(matrix[i][ye]);
      ye--;
      for (int i = ye; i >= ys && xs <= xe; i--)
        ans.add(matrix[xe][i]);
      xe--;
      for (int i = xe; i >= xs && ys <= ye; i--)
        ans.add(matrix[i][ys]);
      ys++;
    }

    return ans;
  }
}
