class VerifyingAnAlienDictionary {
  public boolean isAlienSorted(String[] words, String order) {
    if (words.length == 1)
      return true;

    var orderMapping = new int[26];

    for (var i = 0; i < order.length(); i++) {
      orderMapping[order.charAt(i) - 'a'] = i;
    }

    for (var i = 1; i < words.length; i++) {
      var left = words[i - 1];
      var right = words[i];

      for (var j = 0; j < left.length(); j++) {
        if (right.length() == j)
          return false;
        var leftPos = orderMapping[left.charAt(j) - 'a'];
        var rightPos = orderMapping[right.charAt(j) - 'a'];
        if (leftPos > rightPos)
          return false;
        if (leftPos < rightPos)
          break;
      }
    }

    return true;
  }
}
