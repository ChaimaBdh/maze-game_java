package maze.items;

import maze.Item;
import maze.characters.mobile.Hero;

/** A class that represents a jewel */
public class Jewel extends Item {

  /** A jewel is defined by its name
   * @param name the jewel's name
   */
  public Jewel(String name) {
    super(name);
  }

  /**
   * Converts the jewel into gold coins.
   */
  public void use(Hero h) {
    int nbJewels = h.getNbOfJewels();
    int gold = nbJewels * 5;
    h.setGoldCoins(gold);
    System.out.println("One jewel worth 5 gold coins !");
    System.out.print("You have " + nbJewels + " jewels, which worth : " + gold + " gold coins.\n");
    h.setQuantityOfJewels(0);
  }

  /**
   * @see maze.Item#toString
   */
   public String toString() {
     return super.toString();
   }

}
