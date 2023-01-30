import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianOfStreams {
  PriorityQueue<Integer> min = new PriorityQueue<>(11, Comparator.reverseOrder());
  PriorityQueue<Integer> max = new PriorityQueue<>();

  // Get a number that's less than
  public void addNum(int num) {
    if (max.isEmpty())
      max.add(num);
    else if (num < max.peek()) {
      min.add(num);

      if (min.size() > max.size() + 1) {
        max.add(min.remove());
      }
    } else {
      max.add(num);

      if (max.size() > min.size() + 1) {
        min.add(max.remove());
      }
    }
  }

  public double findMedian() {
    if (max.size() > min.size())
      return max.peek();
    if (min.size() > max.size())
      return min.peek();

    return (min.peek() + max.peek()) / (double) 2;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
