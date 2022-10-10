package maze.characters.immobile;

import maze.*;
import org.junit.*;
import java.util.*;
import maze.Character;
import static org.junit.Assert.*;

public class SphynxTest {

  private Sphynx sphynx1;
  private Sphynx sphynx2;
  private Cell cell;
  private Cell cell1;
  private Question question1;
  private Question question2;

  @Before
  public void before() {
    this.cell = new Cell(5,5);
    this.sphynx1 = new Sphynx("sphynx1", this.cell) ;
    this.cell1 = new Cell(1, 1);
    this.sphynx2 = new Sphynx("sphynx2", this.cell1);
  }

  @Test
  public void testGetName() {
    assertTrue("sphynx1".equals(this.sphynx1.getName()));
    assertFalse("sphynx1".equals(this.sphynx2.getName()));
    assertTrue("sphynx2".equals(this.sphynx2.getName()));

  }


  @Test
  public void testGetPosition() {
    assertTrue(this.cell == this.sphynx1.getPosition());
    assertFalse(this.cell == this.sphynx2.getPosition());
    assertTrue(this.cell1 == this.sphynx2.getPosition());
  }

  @Test
  public void testSetPosition() {
    Cell newCell1 = new Cell(2, 3);
    Cell newCell2 = new Cell(4, 19);
    assertTrue(this.cell == this.sphynx1.getPosition());
    assertTrue(this.cell1 == this.sphynx2.getPosition());
    this.sphynx1.setPosition(newCell1);
    assertTrue(newCell1 == this.sphynx1.getPosition());
    this.sphynx2.setPosition(newCell2);
    assertTrue(this.sphynx2.getPosition() == newCell2);
  }

  @Test
  public void testCanMove() {
    assertTrue(false == this.sphynx1.canMove());
    assertFalse(true == this.sphynx2.canMove());
  }

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(maze.characters.immobile.SphynxTest.class);
  }
}
