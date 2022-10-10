package maze;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import maze.characters.mobile.Hero;
import maze.exceptions.UnknownCellException;

public class QuestTest {

  private Quest quest;
  private Board b;
  private Board b2;
  private Hero hero;
  private Cell cell;

  @Before
  public void before() throws UnknownCellException {
    this.b = new Board(8, 6);
    this.b2 = new Board(10, 10);
    this.cell = new Cell(2, 3);
    this.hero = new Hero("hero", this.cell);
    this.quest = new Quest(this.b2, this.hero);
  }

  // @Test
  // public void testQuestIsFinishedWhenHeroReachesFinalCell() {
  //   this.hero.setPosition(this.quest.getQuestCell());
  //   assertEquals(this.hero.getPosition(), this.quest.getQuestCell());
  //   assertTrue(this.quest.isFinished());
  // }

  // @Test
  // public void testQuestIsFinishedWhenHeroHas20Gold() {
  //   this.hero.setGoldCoins(20);
  //   assertEquals(this.hero.getGold(), 20);
  //   assertTrue(this.quest.isFinished());
  // }

  @Test
  public void testQuestIsFinishedWhenHeroReachesFinalCellAndHas5Gold() throws UnknownCellException {
    Cell cell = this.b2.getCell(8,3);
    this.hero.setGoldCoins(5);
    assertEquals(this.hero.getGold(), 5);
    assertFalse(this.quest.isFinished());
    this.hero.setPosition(cell);
    assertEquals(this.hero.getPosition(), cell);
    assertTrue(this.quest.isFinished());
  }



  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(maze.QuestTest.class);
  }
}
