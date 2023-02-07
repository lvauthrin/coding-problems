class FindPivoIndex {
  public int pivotIndex(int[] nums) {
    if (nums.length < 1) {
      return -1;
    }

    var sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    var leftSum = 0;

    for (int i = 0; i < nums.length; i++) {
      var rightSum = sum - (leftSum + nums[i]);

      if (leftSum == rightSum) {
        return i;
      }

      leftSum += nums[i];
    }

    return -1;
  }
}
