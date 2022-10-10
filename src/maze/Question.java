package maze;

/** A class to represent the question that the sphynx will ask to the hero */
public class Question {

  /** the question */
  private final String question;

  /** the question's solution */
  private final String solution;

  /** A question is defined by its query and its solution.
   * @param question the question
   * @param solution the solution
   */
  public Question(String question, String solution) {
    this.question = question;
    this.solution = solution;
  }

  /** Returns the question
   * @return the question
   */
  public String getQuestion() {
    return this.question;
  }

  /** Returns the question's solution
   * @return the question's solution
   */
  public String getSolution() {
    return this.solution;
  }
}
