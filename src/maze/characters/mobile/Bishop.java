package maze.characters.mobile;

import maze.*;
import java.util.*;
import maze.characters.mobile.Hero;
import maze.interfaces.InteractiveCharacter;

/** A class that represents the bishop's character */
public class Bishop extends MobileCharacter implements InteractiveCharacter {

  /** list of all sentences that can be said by the bishop */
  private List<String> sentences;

  /** A bishop is defined by its name and its position.
   * @param name the bishop's name
   * @param position the bishop's position
   */
  public Bishop(String name, Cell position) {
    super(name, position);
    this.sentences = new ArrayList<>();
    this.initSentences();
  }

  /** A bishop with no current cell (== null)
   * @param name the hero's name;
   */
  public Bishop(String name) {
    super(name, null);
    this.sentences = new ArrayList<>();
    this.initSentences();
  }

  /**
   * Initializes sentences that can be said by the bishop
   */
  public void initSentences() {
    this.sentences.add("Here is some advices ... (｡◕‿◕｡), you should go to the NORTH, and right after to the EAST, and then you'll find your way... \n");
    this.sentences.add("Your goal is near the last cell of the maze... \n");
    this.sentences.add("The goal is SOUTH, and then, five cells away... Good luck ! (◠﹏◠) \n");
  }

  /** Returns a random sentence
   * @return a random sentence
   */
  public String randomSentence() {
    Random rand = new Random();
    String sent = this.sentences.get(rand.nextInt(this.sentences.size()));
    return sent;
  }

  /**
   * @see maze.interfaces.InteractiveCharacter#answer
   */
  public void answer(Hero h) {
    System.out.println(h + " asks the bishop, he says : \n");
    System.out.println(this.randomSentence());
  }

}
