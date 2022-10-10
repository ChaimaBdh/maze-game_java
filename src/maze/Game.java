package maze;

import maze.characters.mobile.Hero;
import maze.exceptions.*;

/** A class to represent the game */
public class Game {

  /** the game's board */
  private Board board;

  /** the game's quest */
  private Quest quest;

  /** The game is defined by its board and its quest
   * @param b the game's board
   * @param q the game's quest
   */
  public Game(Board b, Quest q) {
    this.board = b;
    this.quest = q;
  }

  /** Returns the game's board
   * @return the game's board
   */
  public Board getBoard() {
    return this.board;
  }

  /** Returns the game's quest
   * @return the game's quest
   */
  public Quest getQuest() {
    return this.quest;
  }


  /** Puts the hero on the first cell of the board
   * @param h the hero
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void addHero(Hero h) throws UnknownCellException {
    Cell firstCell = this.board.getFirstCell();
    firstCell.setHero(h);
    h.setPosition(firstCell);
  }


  /** Plays the game
   * @param h the hero that plays the game
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
   public void play(Hero h) throws UnknownCellException {

     System.out.println("You are at cell " + h.getPosition().toString());
     while(!this.quest.isFinished()) {
       System.out.println("GOAL IS AT" + this.quest.getQuestCell().toString());
       System.out.println("Hero gold coins : " + h.getGold());

       System.out.println("------------------------------------------------------------------\n");
       System.out.println("You are at cell " + h.getPosition().toString());
       h.doAction();
     }
     System.out.println("CONGRATULATIONS ! You reached the quest, you won the game !! ( ˘ ³˘)♥");
   }


}
