package maze;

import maze.*;
import java.util.*;
import maze.characters.mobile.Hero;
import maze.interfaces.InteractiveCharacter;

/** A class to represent a cell which compose the board's grid */
public class Cell {

  /** the cell's horizontal coordinate */
  private int xCoordinate;
  /** the cell's vertical coordinate */
  private int yCoordinate;
  /** a map that associates to a type wall (key) a boolean value */
  private Map<Wall, Boolean> walls;
  /** the hero occupying the cell */
  private Hero hero;
  /** items occupying the cell */
  private List<Item> items;
  /** characters occupying the cell */
  private List<InteractiveCharacter> characters;

  /** A cell is defined by its coordinates (x,y), initially there are no items and no
   * characters on it.
   * @param x the horizontal coordinate
   * @param y the vertical coordinate
   */
  public Cell(int x, int y) {
    this.xCoordinate = x;
    this.yCoordinate = y;
    this.walls = new HashMap<>();
    this.initWall();
    this.items = new ArrayList<>();
    this.characters = new ArrayList<>();
  }

  /** Returns the horizontal coordinate
   * @return the horizontal coordinate
   */
  public int getHCoordinate() {
    return this.xCoordinate;
  }

  /** Returns the vertical coordinate
   * @return the vertical coordinate
   */
  public int getVCoordinate() {
    return this.yCoordinate;
  }

  /** Returns the walls that compose the cell
   * @return the walls thar compose the cell
   */
  public Set<Wall> getWall() {
    return this.walls.keySet();
  }

  /**
   * Initializes the cell walls to the value true (means it exists)
   */
  public void initWall() {
    this.walls.put(Wall.NORTH, true);
    this.walls.put(Wall.EAST, true);
    this.walls.put(Wall.SOUTH, true);
    this.walls.put(Wall.WEST, true);
  }

  /** Determines if the wall exists or not
   * @param wall the wall
   * @return <code>true</code> iff the wall exists, <code>false</code> if not
   */
  public boolean wallExists(Wall wall) {
    return this.walls.get(wall);
  }

  /** Destroys a wall
   * @param wall the wall to destroy
   */
  public void destroy(Wall wall) {
    this.walls.replace(wall, false);
  }


  /** Returns the list of all destroyed walls of the cell
   * @return list of all destroyed walls of the cell
   */
  public List<Wall> destroyedWalls() {
    List<Wall> destroyed = new ArrayList<>();
    for(Wall w : this.walls.keySet()) {
      if(!this.wallExists(w)) {
        destroyed.add(w);
      }
    }
    return destroyed;
  }


  /** Returns the list of characters occupying the cell
   * @return the list of characters occupying the cell
   */
  public List<InteractiveCharacter> getCharacters() {
    return this.characters;
  }


  /** Returns the list of items on the cell
   * @return the list of items on the cell
   */
  public List<Item> getItems() {
    return this.items;
  }


  /** Sets the item occupying the cell
   * @param item the item
   */
  public void setItem(Item item) {
    this.items.add(item);
  }


  /** Sets the character on the cell
   * @param c the character
   */
  public void setCharacter(InteractiveCharacter c) {
    this.characters.add(c);
  }


  /** Sets the hero on the cell
   * @param h the hero
   */
  public void setHero(Hero h) {
    this.hero = h;
  }

  /** Returns the hero on the cell
   * @return the hero on the cell
   */
   public Hero getHero() {
     return this.hero;
   }


  /** Determines if two cells are equal or not
   * @param o the other object to compare with
   * @return <code>true</code> iff two cells are equal, <code>false</code> if not
   */
   public boolean equals(Object o) {
     if(o instanceof Cell) {
       Cell other = (Cell)o;
       return this.xCoordinate == other.xCoordinate
       && this.yCoordinate == other.yCoordinate;
     }
     return false;
   }

   /**
    * @return a string representation of the cell
    */
   public String toString() {
     return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
   }


   /**
    * Displays the hero's symbol
    * @return the hero's symbol
    */
   public String displayHero() {
     if(this.hero != null) {
       return " ☻ ";
     }
     if(this.hero == null && !this.items.isEmpty()) {
       return " ◊ ";
     }
     else {
       return "   ";
     }
   }

}
