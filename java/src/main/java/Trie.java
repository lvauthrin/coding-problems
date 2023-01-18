class Trie {
  // Use the last element of the array as a marker for "end"
  final Trie[] letters = new Trie[27];

  public Trie() {
  }

  public void insert(String word) {
    if (word.length() == 0) {
      letters[26] = new Trie();
    } else {
      var index = (word.charAt(0) - 'a');

      if (letters[index] == null) {
        letters[index] = new Trie();
      }

      letters[index].insert(word.substring(1));
    }
  }

  public boolean innerSearch(String word, boolean isPrefix) {
    if (word.length() == 0) {
      return isPrefix || letters[26] != null;
    } else {
      var index = (word.charAt(0) - 'a');

      if (letters[index] != null) {
        return letters[index].innerSearch(word.substring(1), isPrefix);
      }
    }

    return false;
  }

  public boolean search(String word) {
    return this.innerSearch(word, false);
  }

  public boolean startsWith(String prefix) {
    return this.innerSearch(prefix, true);
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
