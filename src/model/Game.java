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
    private int upcoord[];
	private int downcoord[];
	private int leftcoord[];
	private int rightcoord[];
    /**
     * Default constructor.
     * 
     * Initializes the gameGrid array with 9 Field objects and the other
     * to their appropriate values.
     */
    public Game() {
        board = new Board();
        coord= new int[8];
        upcoord = new int[2];
    	downcoord = new int[2];
    	leftcoord = new int[2];
    	rightcoord = new int[2];
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
    public int[] validateMovement(int x, int y){
    	if((x==4 && y<=6)||((x==2 || x== 3 || x==5 || x==6) && y>= 2 && y<=4)){
    		upcoord=validateUp(x,y);
    		board.setFieldOwner(Symbol.X, upcoord[0], upcoord[1]);
    		coord[0]=upcoord[0];
    		coord[1]=upcoord[1];
    	}if((x==2 && y<=6)||((x==0 || x== 1 || x==3 || x==4) && y>= 2 && y<=4)){
    		downcoord=validateDown(x,y);
    		board.setFieldOwner(Symbol.X, downcoord[0], downcoord[1]);
    		coord[2]=downcoord[0];
    		coord[3]=downcoord[1];
    	}if((x<=6 && y==4)||(x>= 2 && x<=4 && (y==2 || y==3  || y==5 || y==6))){
    		leftcoord=validateLeft(x,y);
    		board.setFieldOwner(Symbol.X, leftcoord[0], leftcoord[1]);
    		coord[4]=leftcoord[0];
    		coord[5]=leftcoord[1];
    	}if((x<=6 && y==2)||(x>= 2 && x<=4 && (y==0 || y== 1 || y==3 || y==4))){
    		rightcoord=validateRight(x,y);
    		board.setFieldOwner(Symbol.X, rightcoord[0], rightcoord[1]);
    		coord[6]=rightcoord[0];
    		coord[7]=rightcoord[1];
    	}
    	return coord;
    }
    //This method compares the fields involved in the upside movement of a peg 
    public int[] validateUp(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x-1, y).equals(Symbol.O) && board.getFieldOwner(x-2, y).equals(Symbol.NONE)){
    		upcoord[0]=x;
    		upcoord[1]=y;
    	}
    	return upcoord;
    }
  //This method compares the fields involved in the downside movement of a peg 
    public int[] validateDown(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x+1, y).equals(Symbol.O) && board.getFieldOwner(x+2, y).equals(Symbol.NONE)){
    		downcoord[0]=x;
    		downcoord[1]=y;
    	}
    	return downcoord;
    }
  //This method compares the fields involved in the left side movement of a peg 
    public int[] validateLeft(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y-1).equals(Symbol.O) && board.getFieldOwner(x, y-2).equals(Symbol.NONE)){
    		leftcoord[0]=x;
    		leftcoord[1]=y;
    	}
    	return leftcoord;
    }
  //This method compares the fields involved in the left side movement of a peg 
    public int[] validateRight(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y+1).equals(Symbol.O) && board.getFieldOwner(x, y+2).equals(Symbol.NONE)){
    		rightcoord[0]=x;
    		rightcoord[1]=y;
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
    public boolean isGameOver(Symbol userSymbol) {      
        if (pegsCounter == 1 && board.getFieldOwner(3, 3).equals(userSymbol)) return true; else return false;
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
}