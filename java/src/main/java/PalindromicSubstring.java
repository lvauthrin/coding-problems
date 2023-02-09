class PalindromicSubstring {
  public int countSubstrings(String s) {
    var total = 0;

    for (int i = 0; i < s.length(); i++) {
      var l = i;
      var r = i;

      while (l >= 0 && r < s.length()) {
        if (s.charAt(l) == s.charAt(r)) {
          total += 1;
        } else {
          break;
        }

        l--;
        r++;
      }

      l = i;
      r = i + 1;

      while (l >= 0 && r < s.length()) {
        if (s.charAt(l) == s.charAt(r)) {
          total += 1;
        } else {
          break;
        }

        l--;
        r++;
      }
    }

    return total;

  }
}
