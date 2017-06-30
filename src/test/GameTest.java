package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Game;

public class GameTest {

	@Test
	public void validateUp() {
		Game game = new Game();
		
		int[] coords = game.validateUp(5, 3);
		
		assertEquals(5, coords[0]);
		assertEquals(3, coords[1]);
	}
	
	@Test
	public void validateRight() {
		Game game = new Game();
		
		int[] coords = game.validateRight(3, 2);
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);
	}
	
	@Test
	public void validateDown() {
		Game game = new Game();
		
		int[] coords = game.validateDown(1, 3);
		
		assertEquals(1, coords[0]);
		assertEquals(3, coords[1]);
	}
	
	@Test
	public void validateLeft() {
		Game game = new Game();
		
		int[] coords = game.validateUp(5, 5);
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);
	}

}
