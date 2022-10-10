package maze.actions;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import maze.*;
import maze.characters.mobile.*;
import maze.characters.immobile.*;
import maze.interfaces.InteractiveCharacter;

public class HelpTest {

  private Help help1;
  private Help help2;
  private Hero hero;
  private String heroName;

  @Before
  public void before() {
    this.help1 = new Help();
    this.help2 = new Help();
    this.heroName = "soro";
    this.hero = new Hero(this.heroName);
  }

  @Test
  public void testWhenHelpIsPossible() {
    assertTrue(this.help1.isPossible(this.hero) == true);
    assertFalse(this.help2.isPossible(this.hero) == false);
    assertTrue(this.help2.isPossible(this.hero) == true);
  }

  @Test
  public void testDescription() {
    assertEquals(this.help1.description(), "to obtain this help message\n");
    assertEquals(this.help2.description(), "to obtain this help message\n");
  }

  @Test
  public void testToString(){
    assertEquals(this.help1.toString(), "help");
    assertEquals(this.help2.toString(), "help");
  }

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(maze.actions.HelpTest.class);
  }

}
