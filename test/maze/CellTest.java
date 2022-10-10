package maze;

import org.junit.*;
import java.util.*;
import maze.items.*;
import maze.interfaces.InteractiveCharacter;
import maze.characters.mobile.*;
import maze.characters.immobile.*;
import static org.junit.Assert.*;

public class CellTest {

  @Test
  public void testGetHorizontalCoordinate() {
    Cell cell = new Cell(1, 2);
    assertEquals(1, cell.getHCoordinate());
  }

  @Test
  public void testGetVerticalCoordinate() {
    Cell cell = new Cell(1, 2);
    assertEquals(2, cell.getVCoordinate());
  }

  @Test
  public void testEqualsWhenTwoCellsAreTheSame() {
    Cell cell1 = new Cell(5, 3);
    Cell cell2 = new Cell(5, 3);
    assertTrue(cell1.equals(cell2));
  }

  @Test
  public void testEqualsWhenTwoCellsAreNotTheSame() {
    Cell cell1 = new Cell(5, 3);
    Cell cell2 = new Cell(6, 7);
    assertFalse(cell1.equals(cell2));
  }

  @Test
  public void testWallWhenExists() {
    Cell cell = new Cell(5, 3);
    assertTrue(cell.wallExists(Wall.NORTH));
    assertTrue(cell.wallExists(Wall.SOUTH));
    assertTrue(cell.wallExists(Wall.EAST));
    assertTrue(cell.wallExists(Wall.WEST));
  }

  @Test
  public void testWallWhenDoesNotExist() {
    Cell cell = new Cell(7, 4);
    assertTrue(cell.wallExists(Wall.NORTH));
    assertTrue(cell.wallExists(Wall.SOUTH));
    cell.destroy(Wall.NORTH);
    assertFalse(cell.wallExists(Wall.NORTH));
    assertTrue(cell.wallExists(Wall.SOUTH));
  }

  @Test
  public void testDestroyWall() {
    Cell cell = new Cell(8, 6);
    assertTrue(cell.wallExists(Wall.EAST));
    assertTrue(cell.wallExists(Wall.SOUTH));
    cell.destroy(Wall.SOUTH);
    assertTrue(cell.wallExists(Wall.EAST));
    assertFalse(cell.wallExists(Wall.SOUTH));
  }

  @Test
  public void testGetCharacterOnCell() {
    Cell cell = new Cell(6, 6);
    Bishop bish = new Bishop("bishop", cell);
    assertTrue(cell.getCharacters().isEmpty());
    cell.setCharacter(bish);
    assertTrue(cell.getCharacters().contains(bish));
  }

  @Test
  public void testGetItemOnCell() {
    Cell cell = new Cell(6, 6);
    Hero h = new Hero("Wissal", cell);
    Item scroll = new Scroll("scroll");
    assertTrue(cell.getItems().isEmpty());
    cell.setItem(scroll);
    assertTrue(cell.getItems().contains(scroll));
  }

  @Test
  public void testSetItem() {
    Cell cell = new Cell(3,8);
    Hero h = new Hero("hero", cell);
    Item jewel = new Jewel("jewel");
    assertTrue(cell.getItems().isEmpty());
    cell.setItem(jewel);
    assertFalse(cell.getItems().isEmpty());
  }

  @Test
  public void testSetCharacter() {
    Cell cell = new Cell(4, 6);
    assertTrue(cell.getCharacters().isEmpty());
    Trader tr = new Trader("soro", cell);
    cell.setCharacter(tr);
    assertFalse(cell.getCharacters().isEmpty());
  }

  @Test
  public void testGetHero() {
    Cell cell = new Cell(2,7);
    Hero her = new Hero("her",cell);
    assertEquals(cell, her.getPosition());
  }

  @Test
  public void testSethero() {
    Cell c = new Cell (4,7);
    Hero h = new Hero("ndao");
    c.setHero(h);
    assertEquals(h, c.getHero());
  }

  @Test
  public void testToString(){
    Cell cell = new Cell(1,3);
    assertTrue(cell.getHCoordinate() == 1);
    assertTrue(cell.getVCoordinate() == 3);
    assertEquals(cell.toString() , "(1,3)");

  }

  @Test
  public void testDisplayHeroWhenHeroDoesNotExist(){
    Cell cell1 = new Cell (3, 3);
    assertEquals(cell1.displayHero(), "   ");
  }

  @Test
  public void testHeroWhenHeroExists(){
    Cell cell = new Cell(0, 0);
    Hero hero = new Hero("hero");
    assertEquals(cell.displayHero(), "   ");
    cell.setHero(hero);
    assertEquals(cell.displayHero(), " ☻ ");
  }

  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.CellTest.class);
	}
}
