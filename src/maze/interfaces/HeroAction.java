package maze.interfaces;

import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;

/** An interface that models the hero's actions */
public interface HeroAction {

  /** Definition of the action
   * @param h the hero doing the action
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void apply(Hero h) throws UnknownCellException;

  /** Determines the possibility of doing the action
   * @param h the hero
   * @return <code>true</code> iff the action is possible, <code>false</code> if not
   */
  public boolean isPossible(Hero h);

  /**
   * @return the action's description
   */
  public String description();

  /**
   * @return a string representation of the action
   */
  public String toString();
}
