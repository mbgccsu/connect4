/*
 * Michael Gieras
 * 
 * Use this class along with Game.java to run the game
 */

import java.util.Scanner;

public class FourInARow {

  private static int[][] grid =
      {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},};

  private static boolean win, changeplayer = false;

  private static String column;

  private static String message;

  public static void checkStatus() {

    // vertical check
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length - 3; col++) {
        if (grid[row][col] != 0 && grid[row][col + 1] != 0 && grid[row][col + 2] != 0
            && grid[row][col + 3] != 0 && grid[row][col] == grid[row][col + 1]
            && grid[row][col + 2] == grid[row][col + 3]) {
          win = true;
          if (grid[row][col] == 1)
            message = "**Player 1 wins**";
          if (grid[row][col] == 2)
            message = "**Player 2 wins**";
        }
      }
    }

    // horizontal check
    for (int row = 0; row < grid.length - 3; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] != 0 && grid[row + 1][col] != 0 && grid[row + 2][col] != 0
            && grid[row + 3][col] != 0 && grid[row][col] == grid[row + 1][col]
            && grid[row + 2][col] == grid[row + 3][col]) {
          win = true;
          if (grid[row][col] == 1)
            message = "**Player 1 wins**";
          if (grid[row][col] == 2)
            message = "**Player 2 wins**";
        }
      }
    }

    // descending diagonal check
    for (int row = 0; row < grid.length - 3; row++) {
      for (int col = 0; col < grid[0].length - 3; col++) {
        if (grid[row][col] != 0 && grid[row + 1][col + 1] != 0 && grid[row + 2][col + 2] != 0
            && grid[row + 3][col + 3] != 0 && grid[row][col] == grid[row + 1][col + 1]
            && grid[row + 2][col + 2] == grid[row + 3][col + 3]) {
          win = true;
          if (grid[row][col] == 1)
            message = "**Player 1 wins**";
          if (grid[row][col] == 2)
            message = "**Player 2 wins**";
        }
      }
    }

    // ascending diagonal check
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length - 3; col++) {
        if (grid[row][col] != 0 && grid[row - 1][col + 1] != 0 && grid[row - 2][col + 2] != 0
            && grid[row - 3][col + 3] != 0 && grid[row][col] == grid[row - 1][col + 1]
            && grid[row - 2][col + 2] == grid[row - 3][col + 3]) {
          win = true;
          if (grid[row][col] == 1)
            message = "**Player 1 wins**";
          if (grid[row][col] == 2)
            message = "**Player 2 wins**";
        }
      }
    }



  }

  public static void main(String[] args) throws InterruptedException {
    Scanner scan = new Scanner(System.in);

    Game game = new Game();

    int row;
    int col;

    while (!win) {
      if (!changeplayer) {
        System.out.println("Player 1's turn");
        System.out.print("Drop in which column? (0, 1, 2, 3, 4)? ");
        column = scan.nextLine();
        col = Integer.parseInt(column);
        row = 4;
        while (grid[col][row] != 0) {
          row--;
        }
        grid[col][row] = 1;
        game.setGrid(grid);
        checkStatus();
        changeplayer = true;
      } else {
        System.out.println("Player 2's turn");
        System.out.print("Drop in which column? (0, 1, 2, 3, 4)? ");
        column = scan.nextLine();
        col = Integer.parseInt(column);
        row = 4;
        while (grid[col][row] != 0) {
          row--;
        }
        grid[col][row] = 2;
        game.setGrid(grid);
        checkStatus();
        changeplayer = false;
      }

      if (win)
        System.out.println(message);
    }
  }
}
