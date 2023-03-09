import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Tic-Tac-Toe game with user/user or user/computer player modes
 *
 * - TODO:Either save state to speed up calculating the winner or hardcode win checks
 * - TODO:Change player and symbol (X or O) association so that it's not separated in multiple classes
 * - TODO:Make computer move selection smarter
 * - TODO:Allow for different size boards?
 */

class TicTacToe {
  enum State {
    Open(" "),
    X("X"),
    O("O");

    private final String chr;

    private State(final String chr) {
      this.chr = chr;
    }

    @Override
    public String toString() {
      return this.chr;
    }
  }

  enum GameState {
    InProgress,
    XWins,
    OWins,
    Tie,
  }

  final State[][] grid = new State[3][3];
  State playerMove = State.X;
  GameState gameState = GameState.InProgress;

  public GameState getGameState() {
    return gameState;
  }

  public void reset() {
    for (var row : grid)
      Arrays.fill(row, State.Open);
  }

  public boolean makeMove(int x, int y) {
    if (gameState != GameState.InProgress) {
      System.out.println("Game already over: " + gameState);
      return false;
    }

    if (grid[x][y] != State.Open) {
      System.out.println("Spot already taken: " + grid[x][y]);
      return false;
    } else {
      grid[x][y] = playerMove;
      playerMove = playerMove == State.X ? State.O : State.X;
    }

    this.display();
    this.gameState = this.getNextState();
    return true;
  }

  public GameState getNextState() {
    var allFilled = true;

    final var rows = IntStream.range(0, 3)
        .boxed()
        .map(i -> new HashSet<State>())
        .collect(Collectors.toList());

    final var cols = IntStream.range(0, 3)
        .boxed()
        .map(i -> new HashSet<State>())
        .collect(Collectors.toList());

    var diagf = new HashSet<State>();
    var diagb = new HashSet<State>();

    for (var x = 0; x < grid.length; x++) {
      for (var y = 0; y < grid.length; y++) {
        if (x == y)
          diagf.add(grid[x][y]);
        if ((Math.abs(x) + Math.abs(y)) == 2)
          diagb.add(grid[x][y]);
        rows.get(x).add(grid[x][y]);
        cols.get(y).add(grid[x][y]);

        if (grid[x][y] == State.Open)
          allFilled = false;
      }
    }

    for (var row : rows) {
      if (row.size() == 1) {
        if (row.contains(State.X))
          return GameState.XWins;
        if (row.contains(State.O))
          return GameState.OWins;
      }
    }

    for (var col : cols) {
      if (col.size() == 1) {
        if (col.contains(State.X))
          return GameState.XWins;
        if (col.contains(State.O))
          return GameState.OWins;
      }
    }

    if (diagf.size() == 1) {
      if (diagf.contains(State.X))
        return GameState.XWins;
      if (diagf.contains(State.O))
        return GameState.OWins;
    }

    if (diagb.size() == 1) {
      if (diagb.contains(State.X))
        return GameState.XWins;
      if (diagb.contains(State.O))
        return GameState.OWins;
    }

    return allFilled ? GameState.Tie : GameState.InProgress;
  }

  public void display() {
    // NOTE: This is a different grid style and approach to coding the grid
    // var gridString = new StringBuilder();
    // gridString.append("-".repeat(13));
    // gridString.append(System.lineSeparator());

    // for (var row : grid) {

    // for (var column : row) {
    // gridString.append("|");
    // gridString.append(" ");
    // gridString.append(column);
    // gridString.append(" ");
    // }

    // gridString.append("|");
    // gridString.append(System.lineSeparator());
    // }

    // gridString.append("-".repeat(13));
    // gridString.append(System.lineSeparator());

    var gridString = Arrays.stream(grid)
        .map(r -> Arrays.stream(r).map(c -> c.toString()).collect(Collectors.joining(" | ")))
        .collect(Collectors.joining("\n--+---+--\n"));

    System.out.println();
    System.out.println(gridString);
    System.out.println();
  }

  public TicTacToe() {
    reset();
  }

  public static class TicTacToePlayer {
    enum PlayerType {
      User,
      Computer;
    }

    private final Scanner scanner;
    private final PlayerType playerType;

    public TicTacToePlayer(final Scanner scanner, final PlayerType playerType) {
      this.scanner = scanner;
      this.playerType = playerType;
    }

    public int[] getNextMove(final TicTacToe game) {
      if (this.playerType == PlayerType.User) {
        System.out.println("What is your next move?");
        System.out.print("x: ");
        var x = scanner.nextInt();
        System.out.print("y: ");
        var y = scanner.nextInt();

        return new int[] { x, y };
      } else {
        return new int[] {
            (int) Math.floor(3 * Math.random()),
            (int) Math.floor(3 * Math.random())
        };
      }
    }
  }

  public static class PlayState {
    final TicTacToe game;
    final TicTacToePlayer a;
    final TicTacToePlayer b;

    public PlayState(final TicTacToe game, final TicTacToePlayer a, final TicTacToePlayer b) {
      this.game = game;
      this.a = a;
      this.b = b;
    }

    boolean isANext = true;

    public TicTacToePlayer getLastPlayer() {
      return isANext ? b : a;
    }

    public void nextMove() {
      int[] move;
      var player = isANext ? a : b;
      var done = false;

      while (!done) {
        move = player.getNextMove(game);
        done = game.makeMove(move[0], move[1]);
      }

      isANext = !isANext;
    }
  }

  public static void main(String[] args) {
    // Requirements:
    // - Play a game of TicTacToe against the computer
    // - Can replay after the game is over
    // - Choose whether you start or go second

    var playAgain = true;

    try (var scanner = new Scanner(System.in)) {
      do {
        final TicTacToe game = new TicTacToe();
        System.out.print("Would you like to start first? [Y/y]: ");
        var start = scanner.next().toLowerCase();

        var playerA = new TicTacToePlayer(scanner, TicTacToePlayer.PlayerType.User);
        var playerB = new TicTacToePlayer(scanner, TicTacToePlayer.PlayerType.Computer);

        final var playState = start.equals("y") ? new PlayState(game, playerA, playerB)
            : new PlayState(game, playerB, playerA);

        while (game.getGameState() == GameState.InProgress) {
          playState.nextMove();
        }

        if (game.getGameState() == GameState.Tie) {
          System.out.println("Draw!!");
        } else if (playState.getLastPlayer().playerType == TicTacToePlayer.PlayerType.User) {
          System.out.println("**********************************");
          System.out.println("🎆 Congratulations on the win!! 🎆");
          System.out.println("**********************************");
        } else {
          System.out.println("Computer rulez!!");
        }

        System.out.println();
        System.out.print("Want to play again? [Y/y]: ");
        playAgain = scanner.next().toLowerCase().equals("y");
      } while (playAgain);
    }
  }
}
