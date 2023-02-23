import java.util.Arrays;

class NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    var left = 0;
    var count = 0;

    /*
     * [1,2] [2,3] [3,4] [1,3]
     * [1,2] [1,3] [2,3] [3,4]
     * l
     * [1,2] [1,3] [2,3] [3,4] c = 1
     * i
     */

    // TODO: Don't need to track indexes, just need to know previous end
    for (var i = 1; i < intervals.length; i++) {
      var first = intervals[left];
      var second = intervals[i];
      if (Math.max(first[0], second[0]) < Math.min(first[1], second[1])) {
        count++;
        // Remove latest interval
        if (first[1] > second[1]) {
          left = i;
        }
      } else {
        left = i;
      }
    }

    return count;
  }
}
