package maze;

import maze.characters.mobile.Hero;

/** A class that represents an item that the hero can pick up or use */
public abstract class Item {

  /** the item's name */
  protected final String name;

  /** the item's position */
  protected Cell position;


  /** An item is defined by its name
   * @param name the item's name
   */
  public Item(String name) {
    this.name = name;
    this.position = null;
  }

  /** An item is defined by its name
   * @param name the item's name
   * @param position the position
   */
  public Item(String name, Cell position) {
    this.name = name;
    this.position = position;
  }

  /** Returns the item's name
   * @return the item's name
   */
  public String getName() {
    return this.name;
  }

  /** Sets the item's position
   * @param pos the position to set
   */
  public void setPosition(Cell pos) {
    this.position = pos;
  }

  /** Returns the item's position
   * @return the item's position
   */
  public Cell getPosition() {
    return this.position;
  }

  /**
   * Use of the item
   * @param h the hero who uses the item
   */
  public abstract void use(Hero h);


  /** Determines if two items are equal or not
   * @param o the other object to compare with
   * @return <code>true</code> iff two items are equal, <code>false</code> if not
   */
  public boolean equals(Object o) {
    if(o instanceof Item) {
      Item other = (Item)o;
      return this.name.equals(other.name);
    }
    return false;
  }


  /**
   * @return a string representation of the item
   */
  public String toString() {
    return this.name;
  }

}
