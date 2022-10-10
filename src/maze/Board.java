package maze;

import java.util.*;
import maze.interfaces.MazeGenerator;
import maze.exceptions.*;
import maze.characters.mobile.Hero;

/** A class to represent the game's labyrinth */
public class Board {

  /** the board's width */
  private int width;
  /** the board's height */
  private int height;
  /** the board is a 2 dimension array */
  private Cell[][] grid;


  /** The game board is defined by its width and its height
   * @param width the board's width
   * @param height the board's height
   */
  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.grid = new Cell[width][height];
    for(int i = 0; i < this.width; i++) {
      for(int j = 0; j < this.height; j++) {
        this.grid[i][j] = new Cell(i, j);
      }
    }
  }

  /** Returns the board's width
   * @return the board's width
   */
  public int getWidth() {
    return this.width;
  }

  /** Returns the board's height
   * @return the board's height
   */
  public int getHeight() {
    return this.height;
  }


  /** Returns the cell at coordinates (x,y) of the board. (0,0) is top left corner cell.
   * @param x the horizontal coordinate
   * @param y the vertical coordinate
   * @return the cell at coordinates (x,y)
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public Cell getCell(int x, int y) throws UnknownCellException {
    try {
      return this.grid[x][y];
    }
    catch(ArrayIndexOutOfBoundsException e) {
      throw new UnknownCellException("Cell out of bound !");
    }
  }

  /** Returns the first cell of the board (of coordinates (0,0)).
   * @return the first cell of the board (of coordinates (0,0))
   */
  public Cell getFirstCell() {
    return this.grid[0][0];
  }

  /** Returns the last cell of the board
   * @return the last cell of the board
   */
  public Cell getLastCell() {
    return this.grid[this.width-1][this.height-1];
  }


  /** selects a maze generation algorithm
   * @param algo the algorithm
   * @throws UnknownAlgorithmException if the algorithm is not valid (does not exist)
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void selectMaze(MazeGenerator algo) throws UnknownAlgorithmException, UnknownCellException {
    try {
      algo.generateMaze(this);
      this.printBoard();
    }
    catch(IllegalArgumentException e) {
      throw new UnknownAlgorithmException("The algorithm does not exist ! ");
    }
  }

  /** Returns a random cell of the board
   * @return a random cell of the board
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public Cell getRandomCell() throws UnknownCellException {
    Random rand = new Random();
    int x = rand.nextInt(this.width);
    int y = rand.nextInt(this.height);

    Cell randomCell = this.getCell(x,y);
    return randomCell;
  }


  /**
   * @return a string representation of the board (maze)
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public String printBoard() throws UnknownCellException {
    String board = "+---".repeat(this.width) + "+";
    for(int y = 0; y < this.height; y++) {
      String line = "|";
      for(int x = 0; x < this.width; x++)
        if(this.getCell(x,y).wallExists(Wall.EAST))
           line += this.getCell(x,y).displayHero()+"|";
        else
           line += this.getCell(x,y).displayHero()+" ";
      board += "\n" + line;
      line = "\n+";
      for(int x = 0; x < this.width; x++)
        if(this.getCell(x,y).wallExists(Wall.SOUTH))
           line += "---+";
        else
           line +=  "   +";
       board += line;
    }
    System.out.println(board);

    return "\n" + board;

  }

}
