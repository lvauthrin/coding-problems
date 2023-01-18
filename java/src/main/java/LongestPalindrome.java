import java.util.HashMap;

class longestPalindrome {
  public int longestPalindrome(String s) {
    var charCounts = new HashMap<Character, Integer>();

    for (var chr : s.toCharArray()) {
      charCounts.compute(chr, (k, v) -> v == null ? 1 : v + 1);
    }

    int count = 0;

    for (var value : charCounts.values()) {
      count += (value / 2) * 2;

      if (value % 2 == 1 && count % 2 == 0)
        count++;
    }

    return count;
  }
}
