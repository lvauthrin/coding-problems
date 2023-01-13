import java.lang.Math;
import java.util.PriorityQueue;

class KClosestToOrigin {
  private double distance(int i, int j) {
    return Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
  }

  public int[][] kClosest(int[][] points, int k) {
    var heap = new PriorityQueue<int[]>(
        points.length * points[0].length,
        (e1, e2) -> Double.compare(distance(e1[0], e1[1]), distance(e2[0], e2[1])));

    for (int i = 0; i < points.length; i++) {
      heap.add(new int[] { points[i][0], points[i][1] });
    }

    var topk = new int[k][2];

    for (int i = 0; i < k; i++) {
      topk[i] = heap.poll();
    }

    return topk;
  }
}
