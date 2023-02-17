import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    var cols = IntStream.range(0, board.length).boxed().map(v -> new HashSet<Character>()).collect(Collectors.toList());
    var rows = IntStream.range(0, board.length).boxed().map(v -> new HashSet<Character>()).collect(Collectors.toList());
    var grids = IntStream.range(0, board.length).boxed().map(v -> new HashSet<Character>())
        .collect(Collectors.toList());

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        var c = board[i][j];

        if (c == '.')
          continue;

        if (!rows.get(i).add(c) || !cols.get(j).add(c) || !grids.get((i / 3) * 3 + j / 3).add(c))
          return false;

      }
    }

    return true;
  }
}
