class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    var max = 0;
    var count = 0;

    for (var num : nums) {
      if (num == 0) {
        count = 0;
      } else {
        max = Math.max(max, ++count);
      }
    }

    return max;
  }
}
