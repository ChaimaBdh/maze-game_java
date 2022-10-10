package maze.actions;

import maze.*;
import java.util.*;
import maze.interfaces.HeroAction;
import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;

/** A class to represent the action of looking around */
public class LookAround implements HeroAction {

  /** name of the action */
  private final String name;

  /**
   * The action of looking around is defined by its name
   */
  public LookAround() {
    this.name = "look";
  }

  /**
  * @see maze.interfaces.HeroAction#apply
   */
  public void apply(Hero h) throws UnknownCellException {
    this.displayPossibleDirections(h);
    h.getGame().getBoard().printBoard();
  }

  /**
   * @see maze.interfaces.HeroAction#isPossible
   */
  public boolean isPossible(Hero h) {
    return true;
  }

  /** Displays all directions possible so that the hero can see where he can go.
   * @param h the hero
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void displayPossibleDirections(Hero h) throws UnknownCellException {
    System.out.println("Around it's : \n");
    List<Wall> directions = h.getPosition().destroyedWalls();
    //displays all directions possible
    for(Wall w : directions) {
      if(w == Wall.NORTH) {
        int nx = h.getPosition().getHCoordinate();
        int ny = h.getPosition().getVCoordinate() - 1;
        Cell northCell = h.getGame().getBoard().getCell(nx, ny);
        System.out.println(w.toString() + " : cell " + northCell.toString() + "\n");
      }
      if(w == Wall.SOUTH) {
        int sx = h.getPosition().getHCoordinate();
        int sy = h.getPosition().getVCoordinate() + 1;
        Cell southCell = h.getGame().getBoard().getCell(sx, sy);
        System.out.println(w.toString() + " : cell " + southCell.toString() + "\n");
      }
      if(w == Wall.EAST) {
        int ex = h.getPosition().getHCoordinate() + 1;
        int ey = h.getPosition().getVCoordinate();
        Cell eastCell = h.getGame().getBoard().getCell(ex, ey);
        System.out.println(w.toString() + " : cell " + eastCell.toString() + "\n");
      }
      if(w == Wall.WEST) {
        int wx = h.getPosition().getHCoordinate() - 1;
        int wy = h.getPosition().getVCoordinate();
        Cell westCell = h.getGame().getBoard().getCell(wx, wy);
        System.out.println(w.toString() + " : cell " + westCell.toString() + "\n");
      }
    }
  }

  /**
   * @see maze.interfaces.HeroAction#description
   */
  public String description() {
    return "the hero looks around him\n";
  }

  /**
   * @see maze.interfaces.HeroAction#toString
   */
  public String toString() {
    return this.name;
  }

}
