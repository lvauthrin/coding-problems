class HouseRobber {
  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    nums[1] = Math.max(nums[0], nums[1]);

    for (var i = 2; i < nums.length; i++) {
      var take = nums[i] + nums[i - 2];
      var notake = nums[i - 1];
      nums[i] = Math.max(take, notake);
    }

    return nums[nums.length - 1];
  }
}

/*
 * [ 2, 7, 9, 3, 1]
 * 2 7 11 11 12
 * [ 2, 1, 1, 2]
 * 2 2 3 4
 */
