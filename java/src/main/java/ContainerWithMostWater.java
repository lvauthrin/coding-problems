public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    var i = 0;
    var j = height.length - 1;
    var area = 0;
    var maxArea = 0;

    while (i < j) {
      area = Math.min(height[i], height[j]) * (j - i);
      maxArea = Math.max(area, maxArea);

      if (height[i] < height[j])
        i++;
      else
        j--;

    }

    return maxArea;
  }
}
