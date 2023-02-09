class HouseRobberII {
  public int rob(int[] nums, int start, int end) {
    var first = 0;
    var second = 0;
    var total = 0;

    for (int i = start; i < end; i++) {
      total = Math.max(first + nums[i], second);
      first = second;
      second = total;
    }

    return total;
  }

  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 2)
      return Math.max(nums[0], nums[1]);

    var withFirst = rob(nums, 0, nums.length - 1);
    var withSecond = rob(nums, 1, nums.length);
    System.out.println(withFirst + " " + withSecond);

    return Math.max(withFirst, withSecond);
  }
}

/*


*/
