class TrappingRainWater {
  public int trap(int[] height) {
    var lmax = new int[height.length];
    lmax[0] = height[0];
    var rmax = new int[height.length];
    rmax[rmax.length - 1] = height[height.length - 1];

    for (int i = 1; i < height.length; i++) {
      lmax[i] = Math.max(height[i], lmax[i - 1]);
    }

    for (int i = height.length - 2; i >= 0; i--) {
      rmax[i] = Math.max(height[i], rmax[i + 1]);
    }

    var acc = 0;
    for (int i = 0; i < height.length; i++) {
      // var max = Math.min(lmax[i], rmax[i]);
      acc += Math.min(lmax[i], rmax[i]) - height[i];
    }

    return acc;
  }
}
/*
 * ∑c(i) = min(Lmax, Rmax) - h(i)
 */
