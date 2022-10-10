package maze.characters.mobile;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import maze.*;

public class BishopTest{

  private Bishop bishop;
  private Bishop bis;
  private Cell cell;
  private Cell cell1;

  @Before
  public void before(){
    this.cell = new Cell(3, 8) ;
    this.bishop = new Bishop("bishop", this.cell) ;
    this.cell1 = new Cell(1, 1);
    this.bis = new Bishop("bis", this.cell1);
  }

  @Test
  public void testGetName(){
    assertTrue("bishop".equals(this.bishop.getName()));
    assertFalse("Bis".equals(this.bishop.getName()));
  }

  @Test
  public void testGetPosition(){
    assertTrue(this.cell == this.bishop.getPosition());
    assertFalse(this.cell1 == this.bishop.getPosition());
    assertTrue(this.cell1 == this.bis.getPosition());
  }

  @Test
  public void testSetPosition() {
    assertEquals(this.bishop.getPosition(), cell);
    this.bishop.setPosition(cell1);
    assertEquals(this.bishop.getPosition(), cell1);
  }


  @Test
  public void testCanMove(){
    assertTrue(this.bishop.canMove());
    assertTrue(this.bis.canMove());
  }


  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(maze.characters.mobile.BishopTest.class);
  }
}
