class ReverseInteger {
  public int reverse(int x) {
    var result = 0;
    var cur = Math.abs(x);
    var multiplier = x < 0 ? -1 : 1;

    while (cur > 0) {
      if (Integer.MAX_VALUE / 10 - result < 0) {
        return 0;
      }

      var mod = cur % 10;
      result = result * 10 + mod;
      cur = cur / 10;
    }

    return result * multiplier;

  }
}
