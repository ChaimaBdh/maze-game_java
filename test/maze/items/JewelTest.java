package maze.items;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import maze.*;
import maze.characters.mobile.Hero;

public class JewelTest {

  private Hero hero;
  private Cell cell;

  @Before
  public void before() {
    this.cell = new Cell(5, 9);
    this.hero = new Hero("Thorin", this.cell);
  }

  @Test
  public void testUseWhenHeroHasNoneJewels() {
    Item jewel = new Jewel("jewel");
    assertEquals(this.hero.getNbOfJewels(), 0);
    assertEquals(this.hero.getGold(), 0);
  }

  @Test
  public void testUseWhenHeroHasJewels() {
    Item jewel = new Jewel("jewel");
    assertEquals(this.hero.getNbOfJewels(), 0);
    assertEquals(this.hero.getGold(), 0);
    this.hero.setQuantityOfJewels(4);
    assertEquals(this.hero.getNbOfJewels(), 4);
    jewel.use(this.hero);
    assertEquals(this.hero.getGold(), 20);
    assertEquals(this.hero.getNbOfJewels(), 0);
  }


  @Test
  public void testEqualsWhenTwoJewelsAreEqual() {
    Item jewel = new Jewel("jewel");
    Item jewel2 = new Jewel("jewel");
    assertTrue(jewel.equals(jewel2));
  }

  @Test
  public void testEqualsWhenTwoJewelsAreNotEqual() {
    Item jewel = new Jewel("jewel");
    Item jewel2 = new Jewel("jewel2");
    Item jewel3 = new Jewel("jewel3");
    assertFalse(jewel.equals(jewel2));
    assertFalse(jewel.equals(jewel3));
  }



  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(maze.items.JewelTest.class);
  }
}
