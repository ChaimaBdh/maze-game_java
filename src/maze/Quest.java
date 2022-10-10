package maze;

import maze.characters.mobile.Hero;
import java.util.Random;
import maze.exceptions.UnknownCellException;

/** A class to represent the game's quest */
public class Quest {

  /** the game's board */
  private Board board;

  /** the hero who goes on a quest */
  private Hero hero;

  /** quest's cell */
  private Cell questCell;

  /** A quest is defined by the game's board, and the hero. At its creation,
   * it initializes a random cell.
   * @param b the game's board
   * @param h the hero who goes on a quest
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public Quest(Board b, Hero h) throws UnknownCellException {
    this.board = b;
    this.hero = h;
    this.questCell = this.board.getRandomCell();
  }

  /** A quest is defined by the game's board, the hero and a given cell.
   * @param b the game's board
   * @param h the hero who goes on a quest
   * @param cell the quest cell
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public Quest(Board b, Hero h, Cell cell) throws UnknownCellException {
    this.board = b;
    this.hero = h;
    this.questCell = cell;
  }

  /** Returns the random cell corresponding to the quest
   * @return the random cell corresponding to the quest
   */
  public Cell getQuestCell() {
    return this.questCell;
  }

  /** The game's quest is finished when the hero reaches the quest cell and has 5 or more gold coins.
   * @return <code>true</code> iff the hero has reached the quest cell and has collected 5 or more gold coins, <code>false</code> if not
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public boolean isFinished() throws UnknownCellException {
    return this.hero.getPosition().equals(this.questCell) && this.hero.getGold() >= 5;
  }

}
