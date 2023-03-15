import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    var sb = new StringBuffer();

    for (var str : strs) {
      sb.append(str.length());
      sb.append("|");
      sb.append(str);
    }

    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    var ans = new ArrayList<String>();
    var i = 0;

    while (i < s.length()) {
      var count = 0;

      while (i < s.length() && Character.isDigit(s.charAt(i))) {
        count = count * 10 + (s.charAt(i++) - '0');
      }

      i += 1; // Read the delimiter

      if (count == 0)
        ans.add("");
      else
        ans.add(s.substring(i, i + count));

      i += count;
    }

    return ans;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
