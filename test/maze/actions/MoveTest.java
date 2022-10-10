package maze.actions;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import maze.*;
import maze.characters.mobile.Hero;

public class MoveTest {

  private Move move;
	private Cell position;
	private Hero hero;

	@Before
	public void before() {
		this.move = new Move();
		this.position = new Cell(16, 8);
		this.hero = new Hero("hero", this.position);
	}

	@Test
	public void testToString() {
		assertEquals(this.move.toString(), "move");
	}

	@Test
	public void testMoveIsAlwaysPossible() {
		assertEquals(this.hero.getPosition(), this.position);
		assertTrue(this.move.isPossible(this.hero));
	}



  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.actions.MoveTest.class);
	}
}
