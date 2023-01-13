import java.util.Map;
import java.util.HashMap;

class RomanNumeralToInt {
  final Map<String, Integer> mappings = new HashMap<>() {
    {
      put("I", 1);
      put("IV", 4);
      put("V", 5);
      put("V", 5);
      put("IX", 9);
      put("X", 10);
      put("XL", 40);
      put("L", 50);
      put("XC", 90);
      put("C", 100);
      put("CD", 400);
      put("D", 500);
      put("CM", 900);
      put("M", 1000);
    }
  };

  public int romanToInt(String s) {
    var ans = 0;

    for (int i = 0; i < s.length(); i++) {
      if (i < s.length() - 1 && mappings.containsKey(s.substring(i, i + 2))) {
        ans += mappings.get(s.substring(i, i + 2));
        i++;
      } else {
        ans += mappings.get(s.substring(i, i + 1));
      }
    }

    return ans;
  }
}
