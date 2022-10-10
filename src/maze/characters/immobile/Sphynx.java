package maze.characters.immobile;

import maze.*;
import java.util.*;
import maze.characters.mobile.Hero;
import maze.interfaces.InteractiveCharacter;

/** A class that represents the sphynx's character */
public class Sphynx extends ImmobileCharacter implements InteractiveCharacter {

  /** list of all questions that can be said by the sphynx */
  private List<Question> questions;

  /** A sphynx is defined by its name and its position.
   * @param name the sphynx's name
   * @param position the sphynx's position
   */
  public Sphynx(String name, Cell position) {
    super(name, position);
    this.questions = new ArrayList<>();
    this.initQuestions();
  }

  /** A sphynx with no current cell (== null)
   * @param name the hero's name;
   */
  public Sphynx(String name) {
    super(name, null);
    this.questions = new ArrayList<>();
    this.initQuestions();
  }

  /**
   * Initializes the sphynx's questions
   */
  public void initQuestions() {
    Question q1 = new Question("Who wrote the `stranger` (`L'étranger` in french) ? \n", "camus");
    Question q2 = new Question("Who wrote Lord of the Rings ? \n", "tolkien");
    Question q3 = new Question("Who made the movie Interstellar ? \n", "nolan");
    Question q4 = new Question("Who discovered relativity theory ? \n", "einstein");
    Question q5 = new Question("Who sings `purple rain` ? \n", "prince");
    Question q6 = new Question("In which year took place `La prise de la Bastille` ? \n", "1789");
    Question q7 = new Question("Who painted `La Liberté guidant le peuple`? \n", "delacroix");
    Question q8 = new Question("Who wrote Germinal ? \n", "zola");

    // adding the questions/solutions to the list
    this.questions.add(q1);
    this.questions.add(q2);
    this.questions.add(q3);
    this.questions.add(q4);
    this.questions.add(q5);
    this.questions.add(q6);
    this.questions.add(q7);
    this.questions.add(q8);
  }

  /** Returns a random question
   * @return a random question
   */
  public Question randomQuestion() {
    Random rand = new Random();
    Question query = this.questions.get(rand.nextInt(this.questions.size()));
    return query;
  }

  /**
   * @see maze.interfaces.InteractiveCharacter#answer
   */
  public void answer(Hero h) {
    Question q = this.randomQuestion();
    System.out.println("Answer to the question to obtain a clue ! (in one word)\n");
    System.out.println(q.getQuestion() + "\n");
    // the user enter an answer to the question
    Scanner scan = new Scanner(System.in);
    String ans = scan.nextLine();

    if(ans.equals(q.getSolution())) {
      System.out.println("Congratulations ! (ᵔᴥᵔ) You obtained a clue : the goal is � the position (8,3)\n");
    }
    else {
      System.out.println("Wrong answer ! You won ... nothing ಥ﹏ಥ \n");
    }
  }

}
