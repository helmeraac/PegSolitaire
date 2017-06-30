package model;

import model.Field.Symbol;

/**
 * The logic of the game.
 */
public class Game {
    private Board board;
    
    private int turnsCounter; // the number of turns since the start of the game
    private int pegsCounter; //the number of pegs in game
    private boolean didSomeoneWin; // to check if a player won or if it was a tie
    private int coord[];
    private int upcoord;
	private int downcoord;
	private int leftcoord;
	private int rightcoord;
    /**
     * Default constructor.
     * 
     * Initializes the gameGrid array with 9 Field objects and the other
     * to their appropriate values.
     */
    public Game() {
        board = new Board();
        coord= new int[4];
        upcoord = 0;
    	downcoord = 0;
    	leftcoord = 0;
    	rightcoord = 0;
        turnsCounter = 0;
        didSomeoneWin = false;
    }

    /**
     * Sets the symbol of a specific field.
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     */
    public void setFieldOwner(Symbol userSymbol, int x, int y) {
        board.setFieldOwner(userSymbol, x, y);
    }
    /**
     * Returns an array with the index of the 
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     */
    public int[] validateMovement(int x, int y){
    	if((x==4 && y<=6)||((x==2 || x== 3 || x==5 || x==6) && y>= 2 && y<=4)){
    		coord[0]=validateUp(x,y);
    	}if((x==2 && y<=6)||((x==0 || x== 1 || x==3 || x==4) && y>= 2 && y<=4)){
    		coord[1]=validateDown(x,y);
    	}if((x<=6 && y==4)||(x>= 2 && x<=4 && (y==2 || y==3  || y==5 || y==6))){
    		coord[2]=validateLeft(x,y);
    	}if((x<=6 && y==2)||(x>= 2 && x<=4 && (y==0 || y== 1 || y==3 || y==4))){
    		coord[3]=validateRight(x,y);
    	}
    	return coord;
    }
    //This method compares the fields involved in the upside movement of a peg 
    public int validateUp(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x-1, y).equals(Symbol.O) && board.getFieldOwner(x-2, y).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x-2, y);
    		upcoord=converttoIndex(x-2,y);
    	}
    	return upcoord;
    }
  //This method compares the fields involved in the downside movement of a peg 
    public int validateDown(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x+1, y).equals(Symbol.O) && board.getFieldOwner(x+2, y).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x+2, y);
    		downcoord=converttoIndex(x+2,y);
    	}
    	return downcoord;
    }
  //This method compares the fields involved in the left side movement of a peg 
    public int validateLeft(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y-1).equals(Symbol.O) && board.getFieldOwner(x, y-2).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x, y-2);
    		leftcoord=converttoIndex(x,y-2);
    	}
    	return leftcoord;
    }
  //This method compares the fields involved in the left side movement of a peg 
    public int validateRight(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y+1).equals(Symbol.O) && board.getFieldOwner(x, y+2).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x, y+2);
    		rightcoord=converttoIndex(x,y+2);
    	}
    	return rightcoord;
    }

    /**
     * Returns the owner of a specific field.
     * Note: I used this just for testing.
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     * @return      the owner of the Field as a Symbol
     */
    public Symbol getFieldOwner(int x, int y) {
        return board.getFieldOwner(x, y);
    }

    
    /**
     * Evaluates the board to see if the game is over,
     * and then checks if the number of turns is maxed out at 9.
     * If both are not true, return false;
     * 
     * @return      returns true is game is over. Returns false if otherwise.
     */
    public boolean isGameOver() {      
        if (pegsCounter == 1 && board.getFieldOwner(3, 3).equals(Symbol.O)) return true; else return false;
    }
    
    /**
     * Increments the number of turns.
     */
    public void incrementTurnsCounter() {
        turnsCounter++;
    }
    
    /**
     * Returns the number of turns since the start of the game.
     * 
     * @return      the number of turns since the start of the game.
     */
    public int getTurnsCounter() {
        return turnsCounter;
    }
    

    /**
     * Returns true if a player has won the game. Otherwise, false.
     * 
     * @return      true if a player has won the game. Otherwise, return false.
     */
    public boolean getDidSomeoneWin() {
        return didSomeoneWin;
    }

    /*
     * Increments the number of turns, and then sets the user symbol.
     */
    public void incTurnCounterAndSetUserSymbol() {
        incrementTurnsCounter();
    }

	public Symbol getUserSymbol() {
		return null;
	}
	private int converttoIndex(int x,int y){
		int index = 100 ;
		if(x==0 && y==2)  index = 2;
		if(x==0 && y==3)  index = 3;
		if(x==0 && y==4)  index = 4;
		if(x==1 && y==2)  index = 9;
		if(x==1 && y==3)  index = 10;
		if(x==1 && y==4)  index = 11;
		if(x==2 && y==0)  index = 14;
		if(x==2 && y==1)  index = 15;
		if(x==2 && y==2)  index = 16;
		if(x==2 && y==3)  index = 17;
		if(x==2 && y==4)  index = 18;
		if(x==2 && y==5)  index = 19;
		if(x==2 && y==6)  index = 20;
		if(x==3 && y==0)  index = 21;
		if(x==3 && y==1)  index = 22;
		if(x==3 && y==2)  index = 23;
		if(x==3 && y==3)  index = 24;
		if(x==3 && y==4)  index = 25;
		if(x==3 && y==5)  index = 26;
		if(x==3 && y==6)  index = 27;
		if(x==4 && y==0)  index = 28;
		if(x==4 && y==1)  index = 29;
		if(x==4 && y==2)  index = 30;
		if(x==4 && y==3)  index = 31;
		if(x==4 && y==4)  index = 32;
		if(x==4 && y==5)  index = 33;
		if(x==4 && y==6)  index = 34;
		if(x==5 && y==2)  index = 37;
		if(x==5 && y==3)  index = 38;
		if(x==5 && y==4)  index = 39;
		if(x==6 && y==2)  index = 44;
		if(x==6 && y==3)  index = 45;
		if(x==6 && y==4)  index = 46;
		return index;

	}
}