import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordBreak {
  private Map<String, Boolean> visited = new HashMap<>();

  public boolean wordBreak(String s, Map<Character, List<String>> wordMap) {
    if (visited.containsKey(s)) {
      return visited.get(s);
    }

    if (s.length() == 0) {
      return true;
    }

    if (wordMap.containsKey(s.charAt(0))) {
      for (var word : wordMap.get(s.charAt(0))) {
        if (s.startsWith(word)) {
          var answer = wordBreak(s.substring(word.length()), wordMap);
          visited.put(s, answer);

          if (answer) {
            return true;
          }
        }
      }
    }

    visited.put(s, false);
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    var wordMap = wordDict.stream()
        .collect(Collectors.groupingBy(w -> w.charAt(0)));

    return wordBreak(s, wordMap);
  }

  public static void main(final String args[]) {
    var solution = new WordBreak();
    assert !solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
    assert !solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
    System.out.println("Tests completed");
  }
}

// catsandog
// ^ ^

//
