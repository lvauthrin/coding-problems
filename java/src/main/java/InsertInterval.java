import java.util.ArrayList;

class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    // Two steps:
    // - Find the starting intervals
    // - Find the ending intervals
    // - Merge intervals
    var ans = new ArrayList<int[]>();

    // Add all lower intervals
    var i = 0;

    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      ans.add(intervals[i]);
      i++;
    }

    var start = newInterval[0];
    var end = newInterval[1];

    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
      start = Math.min(intervals[i][0], start);
      end = Math.max(intervals[i][1], end);
      i++;
    }

    ans.add(new int[] { start, end });

    while (i < intervals.length) {
      ans.add(intervals[i]);
      i++;
    }

    return ans.toArray(new int[ans.size()][2]);
  }
}
