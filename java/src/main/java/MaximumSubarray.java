public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    // If negative and max then that's new sum
    // If positive expand to next elment until we hit zero then continue

    int sum = Integer.MIN_VALUE;
    var curSum = sum;

    for (int i = 0; i < nums.length; i++) {
      if (curSum <= 0) {
        if (nums[i] > curSum) {
          curSum = nums[i];
        }
      } else {
        curSum += nums[i];
      }

      if (curSum > sum) {
        sum = curSum;
      }
    }

    return sum;
  }
}
