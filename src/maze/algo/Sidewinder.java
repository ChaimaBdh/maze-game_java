package maze.algo;

import maze.*;
import java.util.*;
import maze.interfaces.MazeGenerator;
import maze.exceptions.*;

/** A class that represents the sidewinder algorithm that will be generated */
public class Sidewinder implements MazeGenerator {

  /** the sidewinder algorithm is defined by its validity.
   * At its creation, the algorithm is valid.
   */
  public Sidewinder() {}

  /**
   * Generates a random maze according to the Sidewinder algorithm
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void generateMaze(Board b) throws UnknownCellException {
    List<Cell> path = new ArrayList<>();
    Random rand = new Random();

    for(int y = 0; y < b.getHeight()-1; y++) {
      path.clear();
      for(int x = 0; x < b.getWidth()-1; x++) {

        Wall res;
        res = rand.nextBoolean() ? Wall.EAST : Wall.SOUTH;
        path.add(b.getCell(x,y));

        if(res == Wall.EAST) {
          b.getCell(x,y).destroy(res);
          b.getCell(x+1, y).destroy(Wall.WEST);
        }
        else {
          int i = rand.nextInt(path.size());
          Cell chosenCell = path.get(i);
          chosenCell.destroy(res);
          Cell southCell = b.getCell(chosenCell.getHCoordinate(), chosenCell.getVCoordinate()+1);
          southCell.destroy(Wall.NORTH);
          path.clear();
        }
      }
    }
    for(int y = 0; y < b.getHeight()-1; y++) {
      b.getCell(b.getWidth()-1,y).destroy(Wall.SOUTH);
      b.getCell(b.getWidth()-1, y+1).destroy(Wall.NORTH);
    }

    for(int x = 0; x < b.getWidth()-1; x++) {
      b.getCell(x,b.getHeight()-1).destroy(Wall.EAST);
      b.getCell(x+1, b.getHeight()-1).destroy(Wall.WEST);
    }
  }

}
