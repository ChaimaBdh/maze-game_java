package maze.characters.mobile;

import maze.*;
import java.util.*;
import maze.characters.mobile.Hero;
import maze.interfaces.InteractiveCharacter;

/** A class that represents the trader's character */
public class Trader extends MobileCharacter implements InteractiveCharacter {

  /** list of all clues that can be given by the trader */
  private List<String> clues;

  /** A trader is defined by its name and its position.
   * @param name the trader's name
   * @param position the trader's position
   */
  public Trader(String name, Cell position) {
    super(name, position);
    this.clues = new ArrayList<>();
    this.initClues();
  }

  /** A trader with no current cell (== null)
   * @param name the hero's name;
   */
  public Trader(String name) {
    super(name, null);
    this.clues = new ArrayList<>();
    this.initClues();
  }

  /**
   * Initializes the clues that can be given by the trader
   */
  public void initClues() {
    // this.clues.add("Trader says the goal is near cell : (8,2)");
    // this.clues.add("Trader says the goal is near cell : (8,0)");
    // this.clues.add("Trader says the goal is near cell : (7,3)");
    // this.clues.add("Trader says the goal is near cell : (8,5)");
  }

  /** Returns a random clue
   * @return a random clue
   */
  public String randomClue() {
    Random rand = new Random();
    String clue = this.clues.get(rand.nextInt(this.clues.size()));
    return clue;
  }

  /**
   * @see maze.interfaces.InteractiveCharacter#answer
   */
  public void answer(Hero h) {
    System.out.println("The trader gives a clue to the hero for 4 gold coins ! \n");
    if(h.getGold() >= 4) {
      System.out.println(h + " gives 4 gold coins to the trader, the trader gives him a clue ... ( ͡° ͜ʖ ͡°) \n");
      h.setGoldCoins(h.getGold() - 4);

      // cell which is near the quest cell
      int cx = h.getGame().getQuest().getQuestCell().getHCoordinate() - 1;
      int cy = h.getGame().getQuest().getQuestCell().getVCoordinate() - 1;
      Cell cellClue = new Cell(cx, cy);

      System.out.println("Trader says the goal is near cell :" + cellClue);
    }
    else {
      System.out.println(h + " does not have enough gold coins to obtain a clue from the trader. Try later... (҂◡_◡) \n");
    }
  }

}
