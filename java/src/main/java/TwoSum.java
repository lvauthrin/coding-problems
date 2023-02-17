import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    var seen = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      var complement = target - nums[i];

      if (seen.containsKey(complement)) {
        return new int[] { i, seen.get(complement) };
      }

      seen.put(nums[i], i);
    }

    return new int[0];
  }
}
