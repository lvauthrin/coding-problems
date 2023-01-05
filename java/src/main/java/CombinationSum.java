import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class CombinationSum {
  public List<List<Integer>> inner(int[] candidates, int target, int curr, List<Integer> nums) {
    if (curr >= candidates.length || target < 0) {
      return null;
    }

      if (target == 0) {
        return Collections.<List<Integer>>singletonList(nums);
      }

      final var withList = new ArrayList<>(nums);
      withList.add(candidates[curr]);
      final var with = this.inner(candidates, target - candidates[curr], curr, withList);
      final var without = this.inner(candidates, target, curr + 1, nums);

      final var answer = new ArrayList<List<Integer>>();

      if (with != null) {
        answer.addAll(with);
      }

      if (without != null) {
        answer.addAll(without);
      }

      return answer;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      return this.inner(candidates, target, 0, new ArrayList<>());
    }

// [2,3,6,7], t=7, i=0 nums = []
  // [2,3,6,7], t=5, i=0, nums = [2]
    // [2,3,6,7], t=3, i=0, nums = [2,2]
      // [2,3,6,7], t=1, i=0, nums = [2,2,2]
        // [2,3,6,7], t=-1, i=0, nums = [2,2,2,2] => null
      // [2,3,6,7], t=1, i=1, nums = [2,2,2]
        // [2,3,6,7], t=-2, i=1, nums = [2,2,2,3] => null
      // ...
    // [2,3,6,7], t=3, i=1, nums = [2,2]
      // [2,3,6,7], t=0, i=1, nums = [2,2,3] => list<nums>

  public static void main (String[] args) {
    final CombinationSum solution = new CombinationSum();
    final List<List<Integer>> answer = solution.combinationSum(new int[] {2,3,6,7}, 7);
    assert answer == Arrays.asList(Arrays.asList(2,2,3), Arrays.asList(7));
    System.out.println("Answer was: " + answer);
  }
}
