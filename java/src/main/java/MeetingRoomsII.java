import java.util.Arrays;
import java.util.stream.Collectors;

class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    var starts = Arrays.stream(intervals).map(i -> i[0]).sorted().collect(Collectors.toList());
    var ends = Arrays.stream(intervals).map(i -> i[1]).sorted().collect(Collectors.toList());

    var start = 0;
    var end = 0;

    var maxCount = 0;
    var count = 0;

    while (start < intervals.length) {
      if (starts.get(start) < ends.get(end)) {
        count++;
        start++;
      } else {
        count--;
        end++;
      }

      maxCount = Math.max(count, maxCount);
    }

    return maxCount;
  }
}
