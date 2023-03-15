class MoveZeroes {
  public void move(int[] nums) {
    int r = 0, w = 0;

    while (r < nums.length && w < nums.length) {
      if (nums[w] != 0)
        w += 1;
      else if (nums[r] != 0 && w < r) {
        var tmp = nums[w];
        nums[w] = nums[r];
        nums[r] = tmp;
      } else {
        r += 1;
      }
    }
  }
}
