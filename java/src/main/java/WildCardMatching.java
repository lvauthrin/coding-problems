import java.util.HashMap;
import java.util.Map;

class WildCardMatching {
  final Map<String, Boolean> seen = new HashMap<String, Boolean>();

  public boolean isMatch(String s, String p, int si, int pi) {
    if (si == s.length() && pi == p.length())
      return true;
    if (si == s.length() && p.substring(pi).chars().allMatch(c -> c == '*'))
      return true;
    // TODO: Assess case of multi-wildcard at the end

    var ans = false;

    if (seen.containsKey(si + ":" + pi)) {
      return seen.get(si + ":" + pi);
    } else if (!(si < s.length() && pi < p.length())) {
      ans = false;
    } else if (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi)) {
      ans = isMatch(s, p, si + 1, pi + 1);
    } else if (p.charAt(pi) == '*') {
      ans = isMatch(s, p, si + 1, pi);
      if (!ans)
        ans = ans || isMatch(s, p, si + 1, pi + 1);
      if (!ans)
        ans = ans || isMatch(s, p, si, pi + 1);
    } else {
      return ans;
    }

    seen.put(si + ":" + pi, ans);
    return ans;
  }

  public boolean isMatch(String s, String p) {
    return isMatch(s, p, 0, 0);
  }
}

/*
 * V
 * practical p*a?
 * 
 * - c: has to match - if no, return false, otherwise move along pattern
 * - ?: can match any letter unless there are no more letters to match - move
 * along pattern
 * - *: can match next letter and move on
 * can just move on
 * 
 */
