package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Game;

public class GameTest {

	@Test
	public void validateUp() {
		Game game = new Game();
		
		game.validateUp(5, 3);
		int[] coords = game.getUpcoord();

		assertEquals(3, coords[0]);
		assertEquals(3, coords[1]);

	}
	
	@Test
	public void validateRight() {
		Game game = new Game();
		
		game.validateRight(3, 2);
		int[] coords = game.getRightcoord();
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);

	}
	
	@Test
	public void validateDown() {
		Game game = new Game();

		game.validateDown(1, 3);
		int[] coords = game.getDowncoord();
		
		assertEquals(3, coords[0]);
		assertEquals(3, coords[1]);

	}
	
	@Test
	public void validateLeft() {
		Game game = new Game();
		
		game.validateLeft(3, 5);
		int[] coords = game.getLeftcoord();
		
		assertEquals(3, coords[0]);
		assertEquals(3, coords[1]);

	}

}