package maze.characters.mobile;
import maze.*;
import maze.Character;

/** A class to determine the character's mobility */
public abstract class MobileCharacter extends Character {

  /** the character's move */
  protected boolean move;

  /** A mobile character is defined by its name, its position and its ability to move.
   * @param name the character's name
   * @param pos the character's position
   */
  public MobileCharacter(String name, Cell pos) {
    super(name, pos);
    this.move = true;
  }

  /** A mobile character is defined by its name and its ability to move.
   * @param name the character's name
   */
  public MobileCharacter(String name) {
    super(name, null);
    this.move = true;
  }

  /** Determines if the character can move or not
   * @return <code>true</code> iff the character can move, <code>false</code> if not
   */
  public boolean canMove() {
    return this.move;
  }

}
