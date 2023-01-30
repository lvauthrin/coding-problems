import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MaximumProfitJobScheduling {
  // Time limit exceeded
  public int jobSchedulingDfs(int[][] jobs, Map<Integer, Integer> memo, int pos, int total) {
    if (pos >= jobs.length)
      return total;
    if (memo.containsKey(pos))
      return total + memo.get(pos);

    var start = jobs[pos][0];
    var end = jobs[pos][1];
    var profit = jobs[pos][2];

    var nextPos = pos + 1;
    for (int i = nextPos; i < jobs.length; i++) {
      if (Math.max(start, jobs[i][0]) < Math.min(end, jobs[i][1]))
        nextPos++;
      else {
        break;
      }
    }

    var without = jobSchedulingDfs(jobs, memo, pos + 1, total);
    var with = jobSchedulingDfs(jobs, memo, nextPos, total + profit);
    var ans = Math.max(without, with);
    memo.put(pos, ans);
    return ans;
  }

  public int jobSchedulingDfsMain(int[] startTime, int[] endTime, int[] profit) {
    // To avoid having to keep track of the "path" (which jobs were scheduled),
    // - sort the jobs by start time and whenever you pick a job, then move to the
    // next non-overlapping
    var jobs = new int[startTime.length][3];

    for (int i = 0; i < startTime.length; i++) {
      jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
    }

    Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

    var memo = new HashMap<Integer, Integer>();
    return jobSchedulingDfs(jobs, memo, 0, 0);
  }

  /*
   * 0 0
   * 3 50
   * 5 90
   * 6 120
   */
  public int jobSchedulingTreeMap(int[] startTime, int[] endTime, int[] profit) {
    var jobs = new int[startTime.length][3];

    for (int i = 0; i < startTime.length; i++) {
      jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
    }

    Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

    var tabulation = new TreeMap<Integer, Integer>();
    tabulation.put(0, 0);

    for (var job : jobs) {
      var newValue = job[2] + tabulation.floorEntry(job[0]).getValue();

      if (newValue > tabulation.lastEntry().getValue()) {
        tabulation.put(job[1], newValue);
      }
    }

    return tabulation.lastEntry().getValue();
  }

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    return jobSchedulingTreeMap(startTime, endTime, profit);
    // return jobSchedulingDfsMain(startTime, endTime, profit);
  }
}
/*
 * [50,10,40,70]
 * [50,10,40,70,0]
 */
