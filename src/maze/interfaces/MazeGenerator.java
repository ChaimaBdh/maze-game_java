package maze.interfaces;

import maze.*;
import maze.exceptions.*;

/**
 * Basic interface for mazes based on different algorithm
 */
public interface MazeGenerator {

  /** generates a random maze
   * @param board the board
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void generateMaze(Board board) throws UnknownCellException;

}
