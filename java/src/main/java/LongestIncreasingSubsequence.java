import java.util.Arrays;

class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    var maxes = new int[nums.length];
    var max = 1;
    Arrays.fill(maxes, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i])
          maxes[i] = Math.max(maxes[i], maxes[j] + 1);
        max = Math.max(max, maxes[i]);
      }
    }

    return max;
  }
}
// [1,1,1,1,1,1]

// [4,10,4,3,8,9]
// 4 4 4 3 3 3
// 1 2 2 3 3 3

// 0,1,0,3,2,3
// 0 0 1 1 2 0
// 1 2 2 3 3 4

// keep track of mins and if curr > prev
// 10,9,2,5,3,7,101,18
// 10 9 2 2 2 2 2 2
// 1 1 1 2 2 3 4 4
