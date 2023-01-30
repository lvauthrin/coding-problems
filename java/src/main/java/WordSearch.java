class WordSearch {
  public boolean exist(char[][] board, String word, int x, int y, int cur) {
    if (cur == word.length())
      return true;
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
      return false;
    if (board[x][y] == '#' || board[x][y] != word.charAt(cur))
      return false;

    board[x][y] = '#';
    var right = exist(board, word, x, y + 1, cur + 1);
    var down = exist(board, word, x + 1, y, cur + 1);
    var left = exist(board, word, x, y - 1, cur + 1);
    var up = exist(board, word, x - 1, y, cur + 1);
    board[x][y] = word.charAt(cur);

    return up || down || left || right;
  }

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exist(board, word, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }
}
