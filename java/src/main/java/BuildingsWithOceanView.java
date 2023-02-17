import java.util.Arrays;

public class BuildingsWithOceanView {

  public int[] find(int[] buildings) {
    int[] indexes = new int[buildings.length];
    int max = 0;
    int c = buildings.length - 1;

    for (int i = buildings.length - 1; i >= 0; i--) {
      if (buildings[i] > max) {
        indexes[c--] = i;
        max = buildings[i];
      }
    }

    return c == buildings.length - 1 ? new int[0] : Arrays.copyOfRange(indexes, c + 1, buildings.length);
  }
}
