package maze.actions;

import maze.*;
import java.util.*;
import maze.interfaces.HeroAction;
import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;

/** A class to represent the move action */
public class Move implements HeroAction {

  /** name of the action */
  private final String name;

  /**
   * The move action is defined by its name.
   */
  public Move() {
    this.name = "move";
  }

  /** Chooses a direction to move on
   * @param h the hero
   * @return the direction to move on
   */
  public Wall chooseDirection(Hero h) {
    List<Wall> directions = h.getPosition().destroyedWalls();
    // the user gives a number that corresponds to the direction's index
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();

    // we get the direction from the index given
    Wall directionChosen = directions.get(i);
    return directionChosen;
  }

  /** Returns the next cell (can be at north, south, east or west) from the hero's position.
   * @param h the hero
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   * @return the next cell
   */
  public Cell nextCell(Hero h) throws UnknownCellException {
    Wall next = this.chooseDirection(h);
    if(next == Wall.NORTH) {
      int nx = h.getPosition().getHCoordinate();
      int ny = h.getPosition().getVCoordinate() - 1;
      return h.getGame().getBoard().getCell(nx, ny);
    }
    else if(next == Wall.SOUTH) {
      int sx = h.getPosition().getHCoordinate();
      int sy = h.getPosition().getVCoordinate() + 1;
      return h.getGame().getBoard().getCell(sx, sy);
    }
    else if(next == Wall.EAST) {
      int ex = h.getPosition().getHCoordinate() + 1;
      int ey = h.getPosition().getVCoordinate();
      return h.getGame().getBoard().getCell(ex, ey);
    }
    else {
      int wx = h.getPosition().getHCoordinate() - 1;
      int wy = h.getPosition().getVCoordinate();
      return h.getGame().getBoard().getCell(wx, wy);
    }
  }


  /**
   * @see maze.interfaces.HeroAction#apply
   */
  public void apply(Hero h) throws UnknownCellException {
    this.displayDirections(h);
    Cell destCell = this.nextCell(h);
    h.getPosition().setHero(null);
    h.setPosition(destCell);
    destCell.setHero(h);
    System.out.println(h + " moves to cell " + destCell.toString());
    h.getGame().getBoard().printBoard();
  }


  /**
   * @see maze.interfaces.HeroAction#isPossible
   */
  public boolean isPossible(Hero h) {
    return true;
  }


  /** Displays all directions possible so that the hero can choose wher he goes.
   * @param h the hero
   */
  public void displayDirections(Hero h) {
    System.out.println("Choose the direction of movement : \n");
    List<Wall> directions = h.getPosition().destroyedWalls();
    // displays all directions possible
    int i = 0;
    for(Wall w : directions) {
      System.out.println(i + " - " + w.toString() + "\n");
      i++;
    }
  }

  /**
   * @see maze.interfaces.HeroAction#description
   */
  public String description() {
    return "the hero moves to a chosen direction\n";
  }

  /**
   * @see maze.interfaces.HeroAction#toString
   */
  public String toString() {
    return this.name;
  }

}
