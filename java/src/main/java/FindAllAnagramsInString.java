import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllAnagramsInString {
  public List<Integer> findAnagrams(String s, String p) {
    int start = 0, end = 0;
    int count = p.length();
    List<Integer> ans = new ArrayList<>();
    Map<Character, Integer> seen = new HashMap<>();

    for (char c : p.toCharArray()) {
      seen.compute(c, (k, v) -> v == null ? 1 : v + 1);
    }

    while (end < s.length()) {
      char c = s.charAt(end);

      if (seen.containsKey(c)) {
        int cCount = seen.get(c);

        if (cCount == 0) {
          char sc = s.charAt(start++);

          while (sc != c) {
            seen.computeIfPresent(sc, (k, v) -> v + 1);
            count++;
            sc = s.charAt(start++);
          }

          if (count == 0) {
            ans.add(start);
          }
        } else {
          seen.put(c, seen.get(c) - 1);

          if (--count == 0) {
            ans.add(start);
          }
        }

        end++;
      } else {
        start = ++end;
        count = p.length();
        seen.clear();

        for (char t : p.toCharArray()) {
          seen.compute(t, (k, v) -> v == null ? 1 : v + 1);
        }
      }
    }

    return ans;
  }
}
