package maze.items;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import maze.*;
import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;


public class ScrollTest {

  private Quest quest;
  private Scroll scroll;
  private String scrollName;
  private Board b;
  private Hero hero;
  private Cell heroCell;
  private String heroName;


  @Before
  public void before() throws UnknownCellException {
    this.b = new Board(10, 10);
    this.heroCell = new Cell (3, 3);
    this.heroName = "hero";
    this.hero = new Hero(this.heroName, this.heroCell);
    this.quest = new Quest(this.b, this.hero);
    this.scrollName = "scrollName";
    this.scroll = new Scroll(this.scrollName);
  }

  @Test
  public void testGetName() {
    assertTrue(this.scroll.getName().equals(this.scrollName));
    assertFalse(this.scroll.getName().equals("SCROLL"));
  }

  @Test
  public void testEqualsBetweenTwoScroll() {
    Scroll scr1 = new Scroll("hero");
    Scroll scr2 = new Scroll("scrollName");
    assertTrue(this.scroll.equals(scr2));
    assertFalse(this.scroll.equals(scr1));
    assertFalse(scr2.equals(scr1));
  }


  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(maze.items.ScrollTest.class);
  }
}
