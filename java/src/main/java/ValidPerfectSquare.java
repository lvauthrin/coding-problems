class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    var start = 0;
    var end = num / 2;

    while (start < end) {
      int mid = start + (end - start) / 2;
      int candidate = mid * mid;

      if (candidate == num) {
        return true;
      } else if (candidate < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }
}
