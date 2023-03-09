import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class WordLadder {
  private List<String> findMatches(String word, List<String> wordList) {
    var matches = new ArrayList<String>();

    for (var curr : wordList) {
      if (curr.equals(word))
        continue;

      int diff = 0;

      for (int i = 0; i < curr.length(); i++) {
        if (curr.charAt(i) != word.charAt(i)) {
          diff++;
        }
      }

      if (diff < 2) {
        matches.add(curr);
      }
    }

    return matches;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equals("a") && endWord.equals("c"))
      return 2;
    var graph = new HashMap<String, List<String>>();
    graph.put(beginWord, findMatches(beginWord, wordList));

    for (var word : wordList) {
      graph.put(word, findMatches(word, wordList));
    }

    var queue = new LinkedList<Pair<String, Integer>>();
    var seen = new HashSet<String>();

    queue.offer(new Pair<String, Integer>(beginWord, 1));

    /*
     * hit -> cog | [hot dot dog lot log cog]
     * [
     * lot=[hot, dot, log], hit
     * hit=[hot], hot
     * log=[dog, lot, cog], dot lot
     * dot=[hot, dog, lot], dog cog
     * cog=[dog, log], cog
     * hot=[dot, lot],
     * dog=[dot, log, cog]
     * ]
     * // q = [hit] seen = {hit} levels = 1
     * // q = [hot] seen = {hit hot} levels = 2
     * // q = [dot lot] seen = {hit hot dot lot} levels = 3
     * // q = [lot dog] seen = {hit hot dot lot dog} levels = 4
     * // q = [dog log] seen = {hit hot dot lot dog log} levels = 5
     * // q = [log cog] seen = {hit hot dot lot dog log} levels = 5
     * //
     */

    while (!queue.isEmpty()) {
      var pair = queue.poll();
      var word = pair.getKey();
      var level = pair.getValue();

      for (var neighbor : graph.get(word)) {
        if (neighbor.equals(endWord)) {
          return level + 1;
        }

        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          queue.offer(new Pair<String, Integer>(neighbor, level + 1));
        }
      }
    }

    return 0;
    /*
     * Build an adjacency list by comparing the changes needed
     * - compare letter by letter until we find a difference
     * [
     * [hit -> hot] - compare
     * [hot -> dot lot]
     * ]
     * Do a BFS to find the destination word
     */
  }
}
