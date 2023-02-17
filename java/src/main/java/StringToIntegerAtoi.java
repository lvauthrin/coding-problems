class StringToInteger {
  public enum State {
    PARSE_LEADING, PARSE_NUMBER, PARSE_TRAILING;
  }

  public int myAtoi(String s) {
    var i = 0;
    var total = 0;
    var sign = 1;
    var state = State.PARSE_LEADING;

    while (i < s.length()) {
      var c = s.charAt(i);

      switch (state) {
        case PARSE_LEADING:
          if (Character.isDigit(c)) {
            state = State.PARSE_NUMBER;
          } else if (c == '-') {
            sign = -1;
            state = State.PARSE_NUMBER;
            i++;
          } else if (c == '+') {
            state = State.PARSE_NUMBER;
            i++;
          } else if (c == ' ') {
            i++;
          } else {
            state = State.PARSE_TRAILING;
          }

          break;
        case PARSE_NUMBER:
          if (!Character.isDigit(c)) {
            state = State.PARSE_TRAILING;
          } else {
            if (sign * total > Integer.MAX_VALUE / 10 ||
                (sign * total == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
              return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
              total *= 10;
              total += sign * (c - '0');
            }
          }

          i++;
          break;
        default:
          i = s.length();
          break;
      }
    }

    return total;
  }
}
