package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Game;

public class GameTest {

	@Test
	public void validateUp() {
		Game game = new Game();
		
		//assertEquals(24, game.validateUp(5, 3));

	}
	
	@Test
	public void validateRight() {
		Game game = new Game();

		//assertEquals(18, game.validateRight(3, 2));

	}
	
	@Test
	public void validateDown() {
		Game game = new Game();

		//assertEquals(24, game.validateDown(1, 3));

	}
	
	@Test
	public void validateLeft() {
		Game game = new Game();
		
		//assertEquals(37, game.validateUp(5, 5));

	}

}