import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class SubsetsII {
  public List<List<Integer>> subsetsWithDupMask(int[] nums) {
    // Sort because we want to avoid creating permutations (just want combinations )
    // For example [2,1,2] should give [..., [1,2]] and not [..., [2,1][1,2]]
    Arrays.sort(nums);
    var seen = new HashSet<List<Integer>>();
    var ans = new ArrayList<List<Integer>>();

    // Iterate through all the possible combinations - 0001, 0002
    for (int n = 0; n < Math.pow(2, nums.length); n++) {
      var curList = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++) {
        var bit = 1 << i;

        if ((n & bit) > 0) {
          curList.add(nums[i]);
        }
      }

      if (!seen.contains(curList)) {
        ans.add(curList);
        seen.add(curList);
      }
    }

    return ans;
  }

  public List<List<Integer>> subsetsWithDupDfs(int[] nums) {
    Arrays.sort(nums);
    var ans = new HashSet<List<Integer>>();
    ans.add(Collections.emptyList());

    for (var i : nums) {
      for (var list : new ArrayList<>(ans)) {
        var item = new ArrayList<Integer>(list);
        item.add(i);
        ans.add(item);
      }
    }

    return new ArrayList<>(ans);
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    return subsetsWithDupMask(nums);
  }
}
