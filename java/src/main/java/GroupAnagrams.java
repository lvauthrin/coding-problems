import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    /*
     * Approach 1:
     * Append each string to a list in a hashmap keyed by the sorted version of the
     * string
     * O(n * mlog(m))
     * aet => [eat, tea, ate],
     * ant => [tan, nat],
     * abt => [bat]
     *
     * Approach 2:
     * Create a "key" for each string based on char counts
     * O(n * m))
     * "#1#0#0#0#1...#1#0#0#0#0#0#0" => [eat, tea, ate],
     * "#1#0#...#0#1#0...#1#0#0#0#0#0#0" => [tan, nat],
     * "#1#1#0#0#1...#1#0#0#0#0#0#0" => [bat]
     */

    var countMap = new HashMap<String, List<String>>();

    for (var str : strs) {
      var sb = new StringBuilder();
      var counts = new int[26];

      for (var c : str.toCharArray()) {
        counts[c - 'a']++;
      }

      for (var i = 0; i < 26; i++) {
        sb.append("#").append(counts[i]);
      }

      countMap.computeIfAbsent(sb.toString(), k -> new ArrayList<String>());
      countMap.get(sb.toString()).add(str);
    }

    return new ArrayList<>(countMap.values());
  }
}
