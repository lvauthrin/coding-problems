import java.util.HashSet;

class HappyNumber {
  public boolean isHappy(int n) {
    var sums = new HashSet<Integer>();
    var cur = n;

    while (cur != 1) {
      var sum = 0;

      for (var c : Integer.toString(cur).toCharArray()) {
        var digit = c - '0';
        sum += Math.pow(digit, 2);
      }

      if (sums.contains(sum))
        return false;
      sums.add(sum);
      cur = sum;
    }

    return true;

  }
}
