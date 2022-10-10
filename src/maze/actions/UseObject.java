package maze.actions;

import maze.*;
import java.util.*;
import maze.interfaces.HeroAction;
import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;

/** A class to represent the action of using an object */
public class UseObject implements HeroAction {

  /** name of the action */
  private final String name;

  /**
   * The action of using an object is defined by its name
   */
  public UseObject() {
    this.name = "use";
  }

  /** Chooses an object of hero's inventory
   * @param h the hero
   * @return the object to use
   */
  public Item chooseObject(Hero h) {
    // hero's inventory
    List<Item> inv = h.getInventory();
    // the user gives a number that corresponds to the index's item
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();

    // we get the item of the inventory from the index
    Item objectChosen = inv.get(i);
    return objectChosen;
  }

  /**
   * @see maze.interfaces.HeroAction#apply
   */
  public void apply(Hero h) throws UnknownCellException {
    this.displayObjects(h);
    Item object = this.chooseObject(h);
    System.out.println(h.toString() + " uses " + object.toString() + "\n");
    object.use(h);
    // after the use of an object, it will be removed from the hero's inventory
    h.getInventory().remove(object);
  }

  /**
   * @see maze.interfaces.HeroAction#isPossible
   */
  public boolean isPossible(Hero h) {
    return !h.getInventory().isEmpty();
  }

  /** Displays hero's inventory so that he can chooses which item he will use.
   * @param h the hero
   */
  public void displayObjects(Hero h) {
    System.out.println("Which item you want to use ? \n");
    List<Item> l = h.getInventory();

    // displays all items of the hero's inventory
    int i = 0;
    for(Item item : l) {
      System.out.println(i + " - " + item.toString() + "\n");
      i++;
    }
  }

  /**
   * @see maze.interfaces.HeroAction#description
   */
  public String description() {
    return "the hero uses a chosen item from his inventory\n";
  }


  /**
   * @see maze.interfaces.HeroAction#toString
   */
  public String toString() {
    return this.name;
  }

}
