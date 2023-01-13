import java.util.Arrays;

class IsoMorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    var to = new char[256];
    var from = new char[256];
    Arrays.fill(to, '0');
    Arrays.fill(from, '0');

    if (s.length() != t.length()) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      char m = t.charAt(i);
      char toC = to[(int) c];
      char fromC = from[(int) m];

      if (toC == '0') {
        if (fromC != '0') {
          return false;
        } else {
          to[(int) c] = m;
          from[(int) m] = c;
        }
      } else {
        if (toC != m || fromC != c) {
          return false;
        }
      }
    }

    return true;
  }
}
