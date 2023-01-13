import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CombinationsOfPhoneNumber {
  final Map<String, List<String>> mappings = new HashMap<>() {
    {
      put("2", Arrays.asList("a", "b", "c"));
      put("3", Arrays.asList("d", "e", "f"));
      put("4", Arrays.asList("g", "h", "i"));
      put("5", Arrays.asList("j", "k", "l"));
      put("6", Arrays.asList("m", "n", "o"));
      put("7", Arrays.asList("p", "q", "r", "s"));
      put("8", Arrays.asList("t", "u", "v"));
      put("9", Arrays.asList("w", "x", "y", "z"));
    }
  };

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return Collections.emptyList();
    }

    var answers = new ArrayList<String>();
    answers.add("");

    for (int i = 0; i < digits.length(); i++) {
      var current = new ArrayList<String>();
      var chars = mappings.get(digits.substring(i, i + 1));

      for (int j = 0; j < answers.size(); j++) {
        for (int k = 0; k < chars.size(); k++) {
          current.add(answers.get(j) + chars.get(k));
        }
      }

      answers = current;
    }

    return answers;
  }
}
