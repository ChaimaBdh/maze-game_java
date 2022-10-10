package maze;

/** A class that represents a character of this game */
public abstract class Character {

  /** the character's name */
  protected final String name;

  /** the character's position */
  protected Cell position;

  /** A character is defined by his name, his position and capacity of move.
   * @param name the character's name
   * @param pos the character's position
   */
  public Character(String name, Cell pos) {
    this.name = name;
    this.position = pos;
  }

  /** A character with no current cell (== null)
   * @param name the character's name;
   */
   public Character(String name) {
     this(name, null);
   }

  /** Returns the character's name
   * @return the character's name
   */
  public String getName() {
    return this.name;
  }

  /** Sets the character's position
   * @param pos the position to set
   */
  public void setPosition(Cell pos) {
    this.position = pos;
  }

  /** Returns the character's position
   * @return the character's position
   */
  public Cell getPosition() {
    return this.position;
  }

  /**
   * @return a string representation of the character
   */
   public String toString() {
     return this.name;
   }
}
