package maze.algo;

import maze.*;
import java.util.*;
import maze.interfaces.MazeGenerator;
import maze.exceptions.*;

/** A class that represents the binary tree algorithm that will be generated */
public class BinaryTree implements MazeGenerator {

  /** the binary tree algorithm is defined by its validity.
   * At its creation, the algorithm is valid.
   */
  public BinaryTree() {}

  /**
   * Generates a random maze according to the binary tree algorithm
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
   public void generateMaze(Board b) throws UnknownCellException {
     for(int y = 0; y < b.getHeight()-1; y++) {
       for(int x = 0; x < b.getWidth()-1; x++) {
         Wall res;
         Random rand = new Random();
         res = rand.nextBoolean() ? Wall.SOUTH : Wall.EAST;
         b.getCell(x, y).destroy(res);
         if(res == Wall.SOUTH) {
           b.getCell(x, y+1).destroy(Wall.NORTH);
         }
         else {
           b.getCell(x+1, y).destroy(Wall.WEST);
         }
       }
     }
     // dernière colonne
     for(int y = 0; y < b.getHeight()-1; y++) {
       b.getCell(b.getWidth()-1, y).destroy(Wall.SOUTH);
       b.getCell(b.getWidth()-1, y+1).destroy(Wall.NORTH);
     }
     // dernière ligne
     for(int x = 0; x < b.getWidth()-1; x++) {
       b.getCell(x, b.getHeight()-1).destroy(Wall.EAST);
       b.getCell(x+1, b.getHeight()-1).destroy(Wall.WEST);
     }
   }

}
