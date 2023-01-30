import java.util.Arrays;
import java.util.LinkedList;

class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    var ans = new LinkedList<int[]>();
    var j = 0;
    ans.add(intervals[j++]);

    while (j < intervals.length) {
      if (Math.max(ans.getLast()[0], intervals[j][0]) <= Math.min(ans.getLast()[1], intervals[j][1])) {
        ans.set(ans.size() - 1, new int[] {
            Math.min(ans.getLast()[0], intervals[j][0]),
            Math.max(ans.getLast()[1], intervals[j][1]),
        });
      } else {
        ans.add(intervals[j]);
      }

      j++;
    }

    return ans.toArray(new int[0][0]);
  }
}
