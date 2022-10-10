package maze.actions;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import maze.*;
import maze.characters.mobile.Hero;

public class LookAroundTest {

	private LookAround look;
	private Cell position;
	private Hero hero;

	@Before
	public void before() {
		this.look = new LookAround();
		this.position = new Cell(5, 3);
		this.hero = new Hero("hero", this.position);
	}

	@Test
	public void testToString() {
		assertEquals(this.look.toString(), "look");
	}

	@Test
	public void testLookAroundIsAlwaysPossible() {
		assertEquals(this.hero.getPosition(), this.position);
		assertTrue(this.look.isPossible(this.hero));
	}


  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.actions.LookAroundTest.class);
	}
}
