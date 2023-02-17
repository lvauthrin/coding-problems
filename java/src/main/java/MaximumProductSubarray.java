class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    var ans = Integer.MIN_VALUE;
    var min = 1;
    var max = 1;

    for (var n : nums) {
      var tmp = max;
      max = Math.max(Math.max(max * n, n), min * n);
      min = Math.min(Math.min(tmp * n, min * n), n);
      ans = Math.max(max, ans);
    }

    return ans;
  }
}
/*
 * 
 * 2 3 -2 4
 * 2 6 -6 4
 * 1 3 -6 -24
 * 
 */
