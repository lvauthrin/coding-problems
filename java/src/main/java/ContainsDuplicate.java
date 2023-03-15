import java.util.HashSet;

class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    var set = new HashSet<Integer>();

    for (var num : nums) {
      if (!set.add(num))
        return true;
    }

    return false;
  }
}
