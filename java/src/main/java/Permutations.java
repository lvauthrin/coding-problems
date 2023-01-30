import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Permutations {
  public List<List<Integer>> permute(int[] nums, List<Integer> cur, Set<Integer> seen) {
    if (nums.length == cur.size())
      return Collections.singletonList(new ArrayList<>(cur));
    var ans = new ArrayList<List<Integer>>();

    for (int i = 0; i < nums.length; i++) {
      if (!seen.contains(nums[i])) {
        cur.add(nums[i]);
        seen.add(nums[i]);
        ans.addAll(permute(nums, cur, seen));
        cur.remove(cur.size() - 1);
        seen.remove(nums[i]);
      }
    }

    return ans;
  }

  public List<List<Integer>> permute(int[] nums) {
    return permute(nums, new LinkedList<>(), new HashSet<>());
  }
}

/*
 * [1,2,3]
 * [1] [2] [3]
 * [1,2] [1,3] [2,1] [2,3] [3,1] [3,2]
 * [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
 */
