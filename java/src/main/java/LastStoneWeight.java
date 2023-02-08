import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    var heap = new PriorityQueue<Integer>(11, Comparator.reverseOrder());
    heap.addAll(Arrays.stream(stones).boxed().collect(Collectors.toList()));

    while (heap.size() > 1) {
      var first = heap.poll();
      var second = heap.poll();
      heap.offer(Math.abs(first - second));
    }

    return heap.poll();
  }
}

//
// last = 7
// [2,7,4,1,8,1]
// r
//
// last = 1
// [1,0]
