package maze.actions;

import maze.*;
import java.util.*;
import maze.items.*;
import maze.interfaces.HeroAction;
import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;


/** A class to represent the action of picking up an object */
public class PickUp implements HeroAction {

  /** name of the action */
  private final String name;

  /**
   * The pick up action is defined by its name
   */
  public PickUp() {
    this.name = "pick";
  }

  /** Chooses an item of the list
   * @param h the hero
   * @return the item to pick up
   */
  public Item chooseItem(Hero h) {
    // list of items occupying the cell where the hero is
    List<Item> items = h.getPosition().getItems();
    // the user gives a number that corresponds to the item's index
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();

    // we get the item of the list from the index
    Item itemChosen = items.get(i);
    return itemChosen;
  }

 /**
  * @see maze.interfaces.HeroAction#apply
  */
  public void apply(Hero h) throws UnknownCellException {
    this.displayItems(h);

    Item item = this.chooseItem(h);
    System.out.println(h.toString() + " picks up " + item.toString() + " into his inventory" + "\n");
    h.getInventory().add(item);
    h.getPosition().getItems().remove(item);
    
    if(item instanceof Jewel) {
      int nbJewels = h.getNbOfJewels();
      h.setQuantityOfJewels(nbJewels+1);
    }
  }

  /**
   * @see maze.interfaces.HeroAction#isPossible
   */
  public boolean isPossible(Hero h) {
    return !h.getPosition().getItems().isEmpty();
  }

  /** Displays items so that the hero choose which one he will pick up.
   * @param h the hero
   */
  public void displayItems(Hero h) {
    System.out.println("What do you want to pick up ? \n");
    List<Item> l = h.getPosition().getItems();
    // displays all items available to pick
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
    return "the hero picks up a chosen item\n";
  }


  /**
   * @see maze.interfaces.HeroAction#toString
   */
  public String toString() {
    return this.name;
  }

}
