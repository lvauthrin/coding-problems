class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int[][] m = new int[s.length()][s.length()];
    var longest = "";

    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = s.length() - 1; j >= i; j--) {
        if (i == j)
          m[i][j] = 1;
        else if (j - i == 1) {
          if (s.charAt(i) == s.charAt(j))
            m[i][j] = 2;
        } else if (i < s.length() && j > 0) {
          var prev = m[i + 1][j - 1];
          if (prev != 0 && s.charAt(i) == s.charAt(j)) {
            m[i][j] = prev + 2;
          }
        }

        if (m[i][j] > longest.length()) {

          longest = s.substring(i, j + 1);
        }
      }
    }

    return longest;
  }
}

// babad
// ^
/*
 * ^>
 * b a b a d
 * b 1 0 3 0 0
 * a 1 0 3 0
 * b 1 0 0
 * a 1 0
 * d 1
 * 
 * 
 * dabad
 * l^r
 * 
 * d a b a d m[i][j] = m[i-1][j+1] + 2
 * d 1 0 0 0 5
 * a 1 0 3 0
 * b 1 0 0
 * a 1 0
 * d 1
 * #47352854
 */
