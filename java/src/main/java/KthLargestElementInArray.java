import java.util.PriorityQueue;

class KthLargestElementInArray {
  public int findKthLargest(int[] nums, int k) {
    final PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (var num : nums) {
      heap.offer(num);
      if (heap.size() > k)
        heap.poll();

    }

    return heap.poll();
  }
}
