class ClimbingStairs {
  public int climbStairs(int n) {
    if (n <= 1)
      return 1;
    var first = 1;
    var second = 1;
    var total = 0;

    for (int i = 1; i < n; i++) {
      total = second + first;
      first = second;
      second = total;
    }

    return total;
  }
}
/*
 * 0 1 2 3 4 5
 * 0 1 2 3 5 8
 * 
 * 1,1,1,1,1
 * 1,1,1,2
 * 1,1,2,1
 * 1,2,1,1
 * 2,1,1,1
 * 2,2,1
 * 1,2,2
 * 2,1,2
 * 
 */
