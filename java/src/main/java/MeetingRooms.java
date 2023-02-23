import java.util.Arrays;

class MeetingRooms {
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length == 0)
      return true;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    var lastEnd = intervals[0][1];

    for (var i = 1; i < intervals.length; i++) {
      var interval = intervals[i];
      if (lastEnd > interval[0])
        return false;
      lastEnd = interval[1];
    }

    return true;
  }
}
