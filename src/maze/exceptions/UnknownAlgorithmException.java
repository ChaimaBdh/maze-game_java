package maze.exceptions;

/** A class to represent an exception thrown when an algorithm is unknown */
public class UnknownAlgorithmException extends Exception {

  /** */
  public UnknownAlgorithmException() {
    super();
  }

  /** An unknown algorithm exception is defined by its message thrown
   * @param msg the message thrown
   */
   public UnknownAlgorithmException(String msg) {
     super(msg);
   }

}
