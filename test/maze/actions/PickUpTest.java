package maze.actions;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import maze.*;
import maze.items.*;
import maze.characters.mobile.Hero;

public class PickUpTest {

	private PickUp pick;
	private Cell cell1;
	private Cell cell2;
	private Hero hero1;
	private Hero hero2;
	private Item item1;
	private Item item2;
	private Item item3;

  @Before
	public void before() {
    this.pick = new PickUp();
    this.cell1 = new Cell(5, 7);
		this.cell2 = new Cell(9, 7);
    this.hero1 = new Hero("hero1", this.cell1);
		this.hero2 = new Hero("hero2", this.cell2);
    this.item1 = new Scroll("scroll");
    this.item2 = new Jewel("jewel");
    this.item3 = new Jewel("jewel2");
	}

	@Test
	public void testToString() {
		assertEquals(this.pick.toString(), "pick");
	}

	@Test
	public void testWhenPickIsPossible() {
		assertEquals(this.hero1.getPosition(), this.cell1);
		assertTrue(this.cell1.getItems().isEmpty());
		assertFalse(this.pick.isPossible(this.hero1));
		this.cell1.setItem(this.item1);
		this.cell1.setItem(this.item2);
		assertFalse(this.cell1.getItems().isEmpty());
		assertTrue(this.cell1.getItems().contains(this.item1));
		assertTrue(this.cell1.getItems().contains(this.item2));
		assertTrue(this.pick.isPossible(this.hero1));
	}

	@Test
	public void testWhenPickIsNotPossible() {
		assertEquals(this.hero2.getPosition(), this.cell2);
		assertTrue(this.cell2.getItems().isEmpty());
		assertFalse(this.pick.isPossible(this.hero2));
	}



  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.actions.PickUpTest.class);
	}
}
