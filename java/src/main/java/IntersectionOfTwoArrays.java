import java.util.Arrays;
import java.util.HashSet;

class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    var items = new HashSet<Integer>();
    Arrays.stream(nums1).forEach(num -> items.add(num));

    var i = 0;
    var ans = new int[Math.min(nums1.length, nums2.length)];

    for (var num : nums2) {
      if (items.contains(num)) {
        ans[i++] = num;
        items.remove(num);
      }
    }

    return Arrays.copyOf(ans, i);
  }
}
