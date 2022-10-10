package maze.actions;

import maze.characters.mobile.Hero;
import maze.interfaces.HeroAction;
import maze.exceptions.UnknownCellException;

/** A class to represent the help action */
public class Help implements HeroAction {

  /** name of the action */
  private final String name;

  /**
   * The help action is defined by its name
   */
  public Help() {
    this.name = "help";
  }

  /**
   * @see maze.interfaces.HeroAction#apply
   */
  public void apply(Hero h) throws UnknownCellException {
    h.displayPossibleActions();
  }

  /**
   * @see maze.interfaces.HeroAction#isPossible
   */
   public boolean isPossible(Hero h) {
     return true;
   }

   /**
    * @see maze.interfaces.HeroAction#description
    */
   public String description() {
     return "to obtain this help message\n";
   }

   /**
    * @see maze.interfaces.HeroAction#toString
    */
   public String toString() {
     return this.name;
   }

}
