import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class IsSubsequence {
  public boolean isSubsequenceDP(String s, String t) {
    var table = new int[s.length()][t.length()];
    if (s.length() == 0)
      return true;

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          table[i][j] = (i == 0 || j == 0) ? 1 : table[i - 1][j - 1] + 1;
          if (table[i][j] == s.length())
            return true;
        } else {
          table[i][j] = Math.max(
              i == 0 ? 0 : table[i - 1][j],
              j == 0 ? 0 : table[i][j - 1]);
        }
      }
    }

    return false;
  }

  public boolean isSubsequenceIndexes(String s, String t) {
    var indexes = new HashMap<Character, List<Integer>>();

    for (int i = 0; i < t.length(); i++) {
      indexes.putIfAbsent(t.charAt(i), new ArrayList<Integer>());
      indexes.get(t.charAt(i)).add(i);
    }

    int curIndex = -1;

    for (int i = 0; i < s.length(); i++) {
      var nums = indexes.get(s.charAt(i));

      if (nums == null) {
        return false;
      }

      var found = false;

      for (int j : nums) {
        if (j > curIndex) {
          found = true;
          curIndex = j;
          break;
        }
      }

      if (!found) {
        return false;
      }
    }

    return true;
  }

  public boolean isSubsequence(String s, String t) {
    return isSubsequenceDP(s, t);
  }
}
