package maze.exceptions;

/** A class to represent an exception thrown when the cell is out of bound */
public class UnknownCellException extends Exception {

  /** */
  public UnknownCellException() {
    super();
  }

  /** An unknown cell exception is defined by its message thrown
   * @param msg the message thrown
   */
  public UnknownCellException(String msg) {
    super(msg);
  }
}
