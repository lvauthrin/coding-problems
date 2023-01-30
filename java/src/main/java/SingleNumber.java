class SingleNumber {
  public int singleNumber(int[] nums) {
    var ans = 0;

    for (var num : nums) {
      ans ^= num;
    }

    return ans;
  }
}
