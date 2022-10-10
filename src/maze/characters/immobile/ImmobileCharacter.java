package maze.characters.immobile;
import maze.*;
import maze.Character;

/** A class to determine the character's immobility */
public abstract class ImmobileCharacter extends Character {

  /** the character's move */
  protected boolean move;

  /** An immobile character is defined by its name, its position and its ability to move.
   * @param name the character's name
   * @param pos the character's position
   */
   public ImmobileCharacter(String name, Cell pos) {
     super(name, pos);
     this.move = false;
   }

   /** An immobile character is defined by its name its ability to move.
    * @param name the character's name
    */
   public ImmobileCharacter(String name) {
     super(name, null);
     this.move = false;
   }

   /** Determines if the character can move or not
    * @return <code>true</code> iff the character can move, <code>false</code> if not
    */
   public boolean canMove() {
     return this.move;
   }

}
