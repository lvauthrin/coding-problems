import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    var ans = new ArrayList<List<Integer>>();
    ans.add(Collections.emptyList());

    for (var i : nums) {
      for (var list : new ArrayList<>(ans)) {
        var item = new ArrayList<Integer>(list);
        item.add(i);
        ans.add(item);
      }
    }

    return ans;

    // [1,2,3]
    // [[]]
    // [[], [1]]
    // [[], [1], [2], [1,2]]
    // [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]

  }
}
