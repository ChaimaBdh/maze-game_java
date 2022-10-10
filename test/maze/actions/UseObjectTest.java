package maze.actions;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import maze.*;
import maze.items.*;
import maze.characters.mobile.Hero;

public class UseObjectTest {

	private UseObject useObject;
	private Cell position;
	private Hero hero;
	private Item item1;
	private Item item2;

	@Before
	public void before() {
		this.useObject = new UseObject();
		this.position = new Cell(4, 2);
		this.hero = new Hero("hero", this.position);
		this.item1 = new Scroll("scroll");
    this.item2 = new Jewel("jewel");
	}

	@Test
	public void testToString() {
		assertEquals(this.useObject.toString(), "use");
	}

	@Test
	public void testWhenUseObjectIsPossible() {
		assertEquals(this.hero.getPosition(), this.position);
		assertTrue(this.hero.getInventory().isEmpty());
		assertFalse(this.useObject.isPossible(this.hero));
		this.hero.getInventory().add(this.item1);
		assertFalse(this.hero.getInventory().isEmpty());
		assertTrue(this.hero.getInventory().contains(this.item1));
		assertTrue(this.useObject.isPossible(this.hero));
		this.hero.getInventory().add(this.item2);
		assertTrue(this.hero.getInventory().contains(this.item2));
		assertTrue(this.useObject.isPossible(this.hero));
	}

	@Test
	public void testWhenUseObjectIsNotPossible() {
		assertEquals(this.hero.getPosition(), this.position);
		assertTrue(this.hero.getInventory().isEmpty());
		assertFalse(this.useObject.isPossible(this.hero));
	}

  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.actions.UseObjectTest.class);
	}
}
