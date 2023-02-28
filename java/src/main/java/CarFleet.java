import java.util.Arrays;
import java.util.stream.IntStream;

class CarFleet {
  public int carFleet(int target, int[] position, int[] speed) {
    var posAndTime = IntStream.range(0, position.length)
        .boxed()
        .map(i -> new double[] { position[i], (target - position[i]) / (double) speed[i] })
        .toArray(a -> new double[position.length][2]);

    Arrays.sort(posAndTime, (a, b) -> Double.compare(b[0], a[0]));

    var lastTime = 0.0;
    var fleets = 0;

    for (var i = 0; i < posAndTime.length; i++) {
      var time = posAndTime[i][1];
      if (time > lastTime)
        fleets++;
      lastTime = Math.max(time, lastTime);
    }

    return fleets;
  }
}
