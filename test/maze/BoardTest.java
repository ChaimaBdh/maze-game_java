package maze;

import org.junit.*;
import java.util.*;
import maze.exceptions.UnknownCellException;
import static org.junit.Assert.*;

public class BoardTest {

  private Board board1;
  private Board board2;
  private Cell cell0;
  private Cell cell1;
  private Cell cell2;
  private Cell cell3;
  private Cell cell4;

  @Before
  public void before() {
    this.board1 = new Board(10, 5);
    this.board2 = new Board(6, 4);
    this.cell0 = new Cell(0, 0);
    this.cell1 = new Cell(0, 4);
    this.cell2 = new Cell(4, 3);
    this.cell3 = new Cell(9, 0);
    this.cell4 = new Cell(9, 4);
  }

  @Test
  public void testGetWidth() {
    assertTrue(10 == this.board1.getWidth());
    assertEquals(6, this.board2.getWidth());
    assertFalse(8 == this.board1.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertTrue(5 == this.board1.getHeight());
    assertEquals(4, this.board2.getHeight());
    assertFalse(9 == this.board2.getHeight());
  }

  @Test
  public void testGetCellWhenCoordinatesAreValids() throws UnknownCellException {
   assertEquals(10, this.board1.getWidth());
   assertEquals(5, this.board1.getHeight());
   assertEquals(this.cell0, board1.getCell(0, 0));
   assertEquals(this.cell1, board1.getCell(0, 4));
   assertEquals(this.cell2, board1.getCell(4, 3));
   assertEquals(this.cell3, board1.getCell(9, 0));
   assertEquals(this.cell4, board1.getCell(9, 4));
  }

  @Test (expected = UnknownCellException.class)
  public void testGetCellWhenXIsOutOfBounds() throws UnknownCellException {
    assertTrue(6 == board2.getWidth());
    assertEquals(4, board2.getHeight());
    board2.getCell(7, 2);
  }

  @Test (expected = UnknownCellException.class)
  public void testGetCellWhenYIsOutOfBounds() throws UnknownCellException{
    assertTrue(10 == board1.getWidth());
    assertEquals(5, board1.getHeight());
    board1.getCell(7, 8);
  }

  @Test (expected = UnknownCellException.class)
  public void testGetCellWhenYIsNegative() throws UnknownCellException {
    assertTrue(10 == board1.getWidth());
    assertEquals(5, board1.getHeight());
    board1.getCell(7, -8);
  }

  @Test (expected = UnknownCellException.class)
  public void testGetCellWhenXIsNegative() throws UnknownCellException {
    assertTrue(6 == board2.getWidth());
    assertEquals(4, board2.getHeight());
    board2.getCell(-7, 4);
  }

  @Test
  public void testGetFirstCell() {
    assertEquals(this.board2.getFirstCell(), this.cell0);
  }

  @Test
  public void testGetLastCell() {
    Cell cell = new Cell(9, 4);
    assertEquals(this.board1.getLastCell(), cell);
  }



  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.BoardTest.class);
	}
}
