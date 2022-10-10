package maze.characters.mobile;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import maze.*;

public class TraderTest{

  private Trader trader1;
  private Trader trader2;
  private Cell cell1;
  private Cell cell2;

  @Before
  public void before(){
    this.cell1 = new Cell(3, 3) ;
    this.trader1 = new Trader("trader1", this.cell1) ;
    this.cell2 = new Cell(1, 6);
    this.trader2 = new Trader("trader2", this.cell2);
  }

  @Test
  public void testGetName(){
    assertTrue("trader1".equals(this.trader1.getName()));
    assertFalse("hero1".equals(this.trader1.getName()));
    assertTrue("trader2".equals(this.trader2.getName()));
    assertFalse("hero2".equals(this.trader2.getName()));
  }


  @Test
  public void testGetPosition(){
    assertFalse(this.cell2 == this.trader1.getPosition());
    assertTrue(this.cell1 == this.trader1.getPosition());
    assertTrue(this.cell2 == this.trader2.getPosition());
  }

  @Test
  public void testCanMove(){
    assertTrue(this.trader1.canMove());
    assertTrue(this.trader2.canMove());
  }

  @Test
  public void testSetPosition() {
    Cell cell = new Cell(8, 6);
    Cell cell2 = new Cell(5, 5);
    Trader trader = new Trader("trader", cell);
    assertEquals(trader.getPosition(), cell);
    trader.setPosition(cell2);
    assertEquals(trader.getPosition(), cell2);
  }


  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.characters.mobile.TraderTest.class);
	}
}
