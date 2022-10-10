package maze.actions;

import maze.*;
import java.util.*;
import maze.interfaces.HeroAction;
import maze.characters.mobile.Hero;
import maze.interfaces.InteractiveCharacter;
import maze.exceptions.UnknownCellException;

/** A class to represent the interact action */
public class Interact implements HeroAction {

  /** name of the action */
  private final String name;

  /**
   * The interact action is defined by its name
   */
  public Interact() {
    this.name = "interact";
  }

  /** Chooses a character to interact with
   * @param h the hero
   * @return the character to interact with
   */
  public InteractiveCharacter chooseChar(Hero h) {
    // list of characters occupying the cell where the hero is
    List<InteractiveCharacter> characters = h.getPosition().getCharacters();
    // the user gives a number that corresponds to the characters's index
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();

    // we get the character of the list from the index
    InteractiveCharacter c = characters.get(i);
    return c;
  }

  /**
   * @see maze.interfaces.HeroAction#apply
   */
  public void apply(Hero h) throws UnknownCellException {
    this.displayCharacters(h);
    InteractiveCharacter c = this.chooseChar(h);
    System.out.println(h.toString() + " interact with " + c.toString() + "\n");
    c.answer(h);
    h.getPosition().getCharacters().remove(c);
  }

  /**
   * @see maze.interfaces.HeroAction#isPossible
   */
  public boolean isPossible(Hero h) {
    return !h.getPosition().getCharacters().isEmpty();
  }

  /** Displays the characters so that the hero choose which one he will interact with.
   * @param h the hero
   */
  public void displayCharacters(Hero h) {
    System.out.println("Who you want to interact with ? \n");
    List<InteractiveCharacter> l = h.getPosition().getCharacters();
    // displays all characters available to interact with
    int i = 0;
    for(InteractiveCharacter c : l) {
      System.out.println(i + " - " + c.toString() + "\n");
      i++;
    }
  }

  /**
   * @see maze.interfaces.HeroAction#description
   */
  public String description() {
    return "to interact with a character\n";
  }

  /**
   * @see maze.interfaces.HeroAction#toString
   */
  public String toString() {
    return this.name;
  }

}
