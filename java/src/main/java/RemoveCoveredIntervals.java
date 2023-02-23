import java.util.Arrays;

class RemoveCoveredIntervals {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : b[1] - a[1]);

    var lastInterval = intervals[0];
    var count = intervals.length;

    for (var i = 1; i < intervals.length; i++) {
      var interval = intervals[i];

      if (lastInterval[0] <= interval[0] && interval[1] <= lastInterval[1]) {
        count--;
      } else {
        lastInterval = interval;
      }
    }

    return count;
  }
}
