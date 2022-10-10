package maze;

import org.junit.*;
import java.util.*;
import maze.items.*;
import maze.interfaces.InteractiveCharacter;
import maze.characters.mobile.*;
import maze.characters.immobile.*;
import static org.junit.Assert.*;

public class QuestionTest {

  private Question q1;
  private String question1;
  private String res1;
  private Question q2;
  private String question2;
  private String res2;
  private Question q3;
  private String question3;
  private String res3;


  @Before
    public void before() {
    this.question1 = " where is the pink lake";
    this.res1 = " in Senegal";
    this.question2 = " where is the eiffel tower";
    this.res2 = "in France";
    this.question3 = " what is the third best university in France";
    this.res3 = "Lille1";
    this.q1 = new Question(this.question1, this.res1);
    this.q2 = new Question(this.question2, this.res2);
    this.q3 = new Question(this.question3, this.res3);
  }

  @Test
  public void testGetQuestion(){
    assertEquals(this.q1.getQuestion(), this.question1);
    assertEquals(this.q2.getQuestion(), this.question2);
    assertEquals(this.q3.getQuestion(), this.question3);
  }

  @Test
  public void testGetSolution(){
    assertEquals(this.q1.getSolution(), this.res1);
    assertEquals(this.q2.getSolution(), this.res2);
    assertEquals(this.q3.getSolution(), this.res3);
  }




  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.QuestionTest.class);
	}
}
