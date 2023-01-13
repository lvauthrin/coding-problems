import java.lang.Math;

class RandomPickWithWeight {
  // final int[] ans;
  final int[] sums;

  public RandomPickWithWeight(int[] w) {
    // ans = setupMappingArray();
    sums = new int[w.length];
    sums[0] = w[0];

    for (int i = 1; i < w.length; i++) {
      sums[i] = sums[i - 1] + w[i];
    }
  }

  // private int[] setupMappingArray(int[] w) {
  // int total = 0;
  // int max = 0;
  //
  // for (int i = 0; i < w.length; i++) {
  // total += w[i];
  // max = max < w[i] ? w[i] : max;
  // }
  //
  // final int[] ans = new int[total];
  //
  // int index = 0;
  // for (int i = 0; i < w.length; i++) {
  // for (int j = 0; j < w[i]; j++) {
  // ans[index++] = i;
  // }
  // }
  //
  // return ans;
  // }

  public int pickIndexBinary() {
    final int value = Math.round((float) (Math.random() * sums[sums.length - 1])) + 1;
    var left = 0;
    var right = sums.length - 1;
    var mid = 0;

    // [ 1, 2, 5 , 4]
    // [ 1, 3, 8 , 12]
    // l r
    // m

    while (left <= right) {
      mid = (right + left) / 2;

      if (value <= sums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return value <= sums[mid] ? mid : mid + 1;
  }

  // public int pickIndexMappingArray() {
  // return ans[Math.round((int) (Math.random() * ans.length))];
  // }

  public int pickIndex() {
    return pickIndexBinary();
  }

  /**
   * Your Solution object will be instantiated and called as such:
   * Solution obj = new Solution(w);
   * int param_1 = obj.pickIndex();
   */
  public static void main(String[] args) {
    System.out.println(new RandomPickWithWeight(new int[] { 3, 14, 1, 7 }).pickIndex());
  }

}
