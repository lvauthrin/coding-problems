import java.util.PriorityQueue;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

class KthLargestInStream {
  final PriorityQueue<Integer> heap = new PriorityQueue<>();
  final int k;

  public KthLargestInStream(int k, int[] nums) {
    this.k = k;

    for (var num : nums)
      this.add(num);
  }

  public int add(int val) {
    heap.offer(val);

    if (heap.size() > k)
      heap.poll();

    return heap.peek();
  }
}
