class SortColors {
  public void sortColors(int[] nums) {
    int left = 0;
    int curr = 0;
    var right = nums.length - 1;

    while (curr <= right) {
      if (nums[curr] == 0) {
        var tmp = nums[left];
        nums[left++] = nums[curr];
        nums[curr++] = tmp;
      } else if (nums[curr] == 2) {
        var tmp = nums[right];
        nums[right--] = nums[curr];
        nums[curr] = tmp;
      } else {
        curr++;
      }

    }
  }
}
