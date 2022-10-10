package maze.characters.mobile;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import maze.*;
import maze.items.*;

public class HeroTest{

  private Hero hero1;
  private Hero hero2;
  private Cell cell1;
  private Cell cell2;

  @Before
  public void before() {
    this.cell1 = new Cell(3, 8);
    this.hero1 = new Hero("hero1", this.cell1) ;
    this.cell2 = new Cell(1, 1);
    this.hero2 = new Hero("hero2", this.cell2);
  }

  @Test
   public void testGetName() {
     assertEquals(this.hero1.getName(), "hero1");
     assertEquals(this.hero2.getName(), "hero2");

     assertFalse("java".equals(this.hero1.getName()));
     assertFalse("hero1".equals(this.hero2.getName()));
   }

  @Test
  public void testGetPosition() {
    assertFalse(this.cell2.equals(this.hero1.getPosition()));
    assertTrue(this.cell1.equals(this.hero1.getPosition()));
    assertTrue(this.cell2.equals(this.hero2.getPosition()));
  }


  @Test
  public void testSetPosition() {
    assertEquals(this.hero1.getPosition(), cell1);
    this.hero1.setPosition(cell2);
    assertEquals(this.hero1.getPosition(), cell2);
  }


  @Test
  public void testCanMove() {
    assertTrue(this.hero1.canMove());
    assertTrue(this.hero2.canMove());
  }

  @Test
  public void testInitialHeroInventoryIsEmpty() {
    Item jewel = new Jewel("jewel");
    Item scroll = new Scroll("scroll");
    assertFalse(this.hero1.getInventory().contains(jewel));
    assertFalse(this.hero1.getInventory().contains(scroll));
    assertFalse(this.hero2.getInventory().contains(jewel));
    assertFalse(this.hero2.getInventory().contains(scroll));
  }


  @Test
  public void testGetNbOfJewelsWhenHeroHasNoJewels() {
    assertEquals(this.hero1.getNbOfJewels(), 0);
    assertEquals(this.hero2.getNbOfJewels(), 0);
  }

  @Test
 public void testSetQuantityOfJewels(){
   assertTrue(this.hero1.getNbOfJewels() == 0);
   assertTrue(this.hero2.getNbOfJewels() == 0);
   this.hero1.setQuantityOfJewels(2);
   this.hero2.setQuantityOfJewels(5);
   assertFalse(this.hero2.getNbOfJewels() == 0);
   assertTrue(this.hero1.getNbOfJewels() == 2);
   assertTrue(this.hero2.getNbOfJewels() == 5);

 }

 @Test
 public void testGetGoldInitially(){
   assertTrue(this.hero1.getGold() == 0);
   assertTrue(this.hero2.getGold() == 0);
 }

 @Test
  public void testSetGoldCoins(){
    assertTrue(this.hero1.getGold() == 0);
    assertTrue(this.hero2.getGold() == 0);
    this.hero1.setGoldCoins(10);
    this.hero2.setGoldCoins(8);
    assertFalse(this.hero1.getGold() == 0);
    assertTrue(this.hero1.getGold() == 10);
    assertTrue(this.hero2.getGold() == 8);

  }

  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.characters.mobile.HeroTest.class);
	}
}
