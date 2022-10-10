package maze.items;

import maze.*;
import maze.characters.mobile.Hero;

/** A class that represents a scroll */
public class Scroll extends Item {

  /** A scroll is defined by its name
   * @param name the scroll's name
   */
  public Scroll(String name) {
    super(name);
  }


  /**
   * Reads the scroll : indicates the approximate direction to the goal cell
   * @param h the hero
   */
  public void use(Hero h) {
    // x coordinate of the quest's cell
    int questX = h.getGame().getQuest().getQuestCell().getHCoordinate();
    // y coordinate of the quest's cell
    int questY = h.getGame().getQuest().getQuestCell().getVCoordinate();
    // x coordinate of the hero's position
    int heroX = h.getPosition().getHCoordinate();
    // y coordinate of the hero's position
    int heroY = h.getPosition().getVCoordinate();
    if(questX > heroX) {
      System.out.println("The goal is East");
    }
    else if(questX < heroX) {
      System.out.println("The goal is West");
    }
    else if(questY > heroY) {
      System.out.println("The goal is South");
    }
    else if(questY < heroY) {
      System.out.println("The goal is North");
    }
  }

  /**
   * @see maze.Item#toString
   */
   public String toString() {
     return super.toString();
   }

}
