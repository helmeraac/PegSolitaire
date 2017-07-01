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
        upcoord = new int [2];
    	downcoord = new int [2];
    	leftcoord = new int [2];
    	rightcoord = new int [2];
        turnsCounter = 0;
        didSomeoneWin = false;
    }

    /**
     * Sets the symbol of a specific field.
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     */
    /**
     * Returns an array with the index of the 
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     */
    public int[] validateMovement(int x, int y){
    	if((x==4 && y<=6)||((x==2 || x== 3 || x==5 || x==6) && y>= 2 && y<=4)){
    		validateUp(x,y);
    		coord[0]=upcoord[0];
    		coord[1]=upcoord[1];
    	}if((x==2 && y<=6)||((x==0 || x== 1 || x==3 || x==4) && y>= 2 && y<=4)){
    		validateDown(x,y);
    		coord[2]=downcoord[0];
    		coord[3]=downcoord[1];
    	}if((x<=6 && y==4)||(x>= 2 && x<=4 && (y==2 || y==3  || y==5 || y==6))){
    		validateLeft(x,y);
    		coord[4]=leftcoord[0];
    		coord[5]=leftcoord[1];
    	}if((x<=6 && y==2)||(x>= 2 && x<=4 && (y==0 || y== 1 || y==3 || y==4))){
    		validateRight(x,y);
    		coord[6]=rightcoord[0];
    		coord[7]=rightcoord[1];
    	}
    	return coord;
    }
    /*
     * This method  receives an array with the coordinates of the fields for available movements,
     * an two integers that are the coordinates of the movement done
     */
    public void updateBoardonMove(int[]mov, int x, int y){
    	if(mov[0]==x && mov[1]==y){
    		
    	}if(mov[2]==x && mov[3]==y){
    		
    	}if(mov[4]==x && mov[5]==y){
    		
    	}if(mov[6]==x && mov[7]==y){
    		
    	}    	
    }
    //This method compares the fields involved in the upside movement of a peg 
    public void validateUp(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x-1, y).equals(Symbol.O) && board.getFieldOwner(x-2, y).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x-2, y);
    		upcoord[0]=x-2;
    		upcoord[1]=y;
    	}
    }
  //This method compares the fields involved in the downside movement of a peg 
    public void validateDown(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x+1, y).equals(Symbol.O) && board.getFieldOwner(x+2, y).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x+2, y);
    		downcoord[0]=x+2;
    		downcoord[1]=y;
    	}
    }
  //This method compares the fields involved in the left side movement of a peg 
    public void validateLeft(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y-1).equals(Symbol.O) && board.getFieldOwner(x, y-2).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x, y-2);
    		leftcoord[0]=x;
    		leftcoord[1]=y-2;
    	}
    }
  //This method compares the fields involved in the left side movement of a peg 
    public void validateRight(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y+1).equals(Symbol.O) && board.getFieldOwner(x, y+2).equals(Symbol.NONE)){
    		board.setFieldOwner(Symbol.X, x, y+2);
    		rightcoord[0]=x;
    		rightcoord[1]=y+2;
    	}
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
}