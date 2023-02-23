import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

class MinimumIntervalToIncludeEachQuery {
  public int[] minInterval(int[][] intervals, int[] queries) {
    var positions = new HashMap<Integer, LinkedList<Integer>>();

    for (var i = 0; i < queries.length; i++) {
      positions.computeIfAbsent(queries[i], k -> new LinkedList<>());
      positions.get(queries[i]).addLast(i);
    }

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    Arrays.sort(queries);

    var heap = new PriorityQueue<int[]>(11, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
    var ans = new int[queries.length];

    var j = 0;

    for (var i = 0; i < queries.length; i++) {
      while (j < intervals.length && intervals[j][0] <= queries[i]) {
        heap.offer(new int[] { intervals[j][1] - intervals[j][0] + 1, intervals[j][1] });
        j++;
      }

      while (!heap.isEmpty() && heap.peek()[1] < queries[i]) {
        heap.poll();
      }

      var index = positions.get(queries[i]).removeFirst();
      ans[index] = heap.isEmpty() ? -1 : heap.peek()[0];
    }

    return ans;
  }
}
