import java.util.Arrays;
import java.lang.Math;

class LongestSubstringWithoutRepeating {
  public int lengthOfLongestSubstring(String s) {
    // abcabcbb | indexes = [a:3,b:7,c:5], max = 3
    // s
    // e
    var indexes = new int[256];
    Arrays.fill(indexes, -1);
    int max = 0, start = 0, end = 0;

    while (end < s.length()) {
      char c = s.charAt(end);

      if (indexes[c] >= start) {
        start = indexes[c] + 1;
      }

      indexes[c] = end;
      max = Math.max(end - start + 1, max);
      end++;
    }

    return max;
  }
}
