package maze.actions;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import maze.*;
import maze.characters.mobile.*;
import maze.characters.immobile.*;
import maze.interfaces.InteractiveCharacter;

public class InteractTest {

	private Interact interact;
	private Cell position;
	private Hero hero;
	private InteractiveCharacter char1;
	private InteractiveCharacter char2;
	private InteractiveCharacter char3;

	@Before
	public void before() {
		this.interact = new Interact();
		this.position = new Cell(6,6);
		this.hero = new Hero("hero", this.position);
		this.char1 = new Sphynx("sphynx");
		this.char2 = new Bishop("bishop");
		this.char3 = new Trader("trader");
	}

	@Test
	public void testToString() {
		assertEquals(this.interact.toString(), "interact");
	}

	@Test
	public void testWhenInteractIsPossible() {
		assertEquals(this.hero.getPosition(), this.position);
		assertTrue(this.position.getCharacters().isEmpty());
		assertFalse(this.interact.isPossible(this.hero));
		this.position.setCharacter(this.char1);
		assertFalse(this.position.getCharacters().isEmpty());
		assertTrue(this.position.getCharacters().contains(this.char1));
		assertTrue(this.interact.isPossible(this.hero));
		this.position.setCharacter(this.char2);
		this.position.setCharacter(this.char3);
		assertTrue(this.position.getCharacters().contains(this.char2));
		assertTrue(this.position.getCharacters().contains(this.char3));
		assertTrue(this.interact.isPossible(this.hero));
	}

	@Test
	public void testWhenInteractIsNotPossible() {
		assertEquals(this.hero.getPosition(), this.position);
		assertTrue(this.position.getCharacters().isEmpty());
		assertFalse(this.interact.isPossible(this.hero));
	}


  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(maze.actions.InteractTest.class);
	}
}
