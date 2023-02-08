import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

class TaskScheduler {
  public static record Pair(char task, int n) {
  }

  public int leastIntervalHeap(char[] tasks, int n) {
    var freqMap = new HashMap<Character, Integer>();

    for (var c : tasks) {
      freqMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
    }

    var frequency = new PriorityQueue<Pair>(11, (a, b) -> b.n - a.n);

    for (var entry : freqMap.entrySet()) {
      frequency.offer(new Pair(entry.getKey(), entry.getValue()));
    }

    var ts = 0;
    var schedule = new LinkedList<Pair>();

    while (!frequency.isEmpty() || !schedule.isEmpty()) {
      while (schedule.size() > 0 && schedule.peek().n <= 1)
        schedule.poll();
      if (!schedule.isEmpty() && schedule.size() > n) {
        var eligible = schedule.poll();
        // reschedule directly?
        if (eligible.n > 1)
          frequency.offer(new Pair(eligible.task, eligible.n - 1));
        var pair = frequency.poll();
        schedule.offer(pair);
      } else if (!frequency.isEmpty()) {
        var pair = frequency.poll();
        schedule.offer(pair);
      } else {
        if (schedule.isEmpty())
          break;
        schedule.offer(new Pair('0', 0));
        // Nothing to do
      }

      ts++;
    }

    return ts;
  }

  public int leastInterval(char[] tasks, int n) {
    return leastIntervalHeap(tasks, n);
  }
}

// ["A","A","A","B","B","B"] n=2
// [A, B, idle, A, B, idle, A, B]
// A = 2
// B = 2
// Schedule the tasks w/ highest counts first
// Keep a heap of pair of (item, time scheduled)
// ["A","A","A","B","B","B","C"] n=2
// f = {A:3, B:3}
// sched = (A:3)
//
