package maze.interfaces;

import maze.characters.mobile.Hero;

 /** An interface that models the interaction from a character */
public interface InteractiveCharacter {

  /** Answers to the hero
   * @param h the hero
   */
  public void answer(Hero h);

}
