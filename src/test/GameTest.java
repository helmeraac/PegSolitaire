package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Game;
import model.Field.Symbol;

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
		
		game.validateRight(3, 1);
		int[] coords = game.getRightcoord();
		
		assertEquals(3, coords[0]);
		assertEquals(3, coords[1]);

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
	
	@Test
	public void validateMovement() {
		Game game = new Game();
		
		int[] coords = game.validateMovement(3, 5);
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);
		
		coords = game.validateMovement(5, 3);
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);
		
		coords = game.validateMovement(3, 3);
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);
		
		coords = game.validateMovement(4, 0);
		
		assertEquals(0, coords[0]);
		assertEquals(0, coords[1]);

	}
	
	@Test
	public void validateFieldOwner() {
		Game game = new Game();
		
		Symbol coords = game.getFieldOwner(3, 3);
				
		assertEquals(Symbol.NONE, coords);

	}
	
	@Test
	public void validateTurnCounter() {
		Game game = new Game();
		
		game.incrementTurnsCounter();
				
		assertEquals(1, game.getTurnsCounter());
		
		game.incTurnCounterAndSetUserSymbol();
		
		assertEquals(2, game.getTurnsCounter());

	}
	
	@Test
	public void validateSomeoneWin() {
		Game game = new Game();
		
		boolean win =  game.getDidSomeoneWin();
				
		assertEquals(false, win);

	}

}