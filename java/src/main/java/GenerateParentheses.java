class generateParenthesis {
  public static class Triple {
    public int f;
    public int s;
    public String t;

    public Triple(int f, int s, String t) {
      this.f = f;
      this.s = s;
      this.t = t;
    }
  }

  public List<String> generateParenthesis(int n) {
    if (n == 0)
      return Collections.emptyList();
    var ans = new ArrayList<Triple>();
    ans.add(new Triple(0, 0, ""));

    for (var i = 0; i < n * 2; i++) {
      var curr = new ArrayList<Triple>();

      for (var triple : ans) {
        if (triple.f < n) {
          curr.add(new Triple(triple.f + 1, triple.s, triple.t + "("));
        }

        if (triple.s < triple.f) {
          curr.add(new Triple(triple.f, triple.s + 1, triple.t + ")"));
        }
      }

      ans = curr;
    }

    return ans.stream().map(t -> t.t).collect(Collectors.toList());
  }

  /*
   * "" -> "(" -> "((", "()" => "(((", "(()", "()(", => "((()", "(())", "(()(",
   * "()()", "()((",
   * => "((())" , "(())(", "(()()", "()()(", "()(()",
   * => "((()))" , "(())()", "(()())", "()()()", "()(())",
   * 
   */
}
