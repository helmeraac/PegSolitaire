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
    private int[] coord;
    private int[] upcoord;
	private int[] downcoord;
	private int[] leftcoord;
	private int[] rightcoord;
	private int[] pegsToChange;
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
        pegsToChange = new int[6];
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
    	for(int i=0;i<coord.length;i++){
    		coord[i]=0;    		
    	}
    	validateUp(x,y);
    	validateDown(x,y);
    	validateLeft(x,y);
    	validateRight(x,y);
    	if(upcoord[0]!=0){
    		coord[0]=upcoord[0];
    		coord[1]=upcoord[1];
    	}if(downcoord[0]!=0){
    		coord[2]=downcoord[0];
    		coord[3]=downcoord[1];
    	}if(leftcoord[0]!=0){
    		coord[4]=leftcoord[0];
    		coord[5]=leftcoord[1];
    	}if(rightcoord[0]!=0){
    		coord[6]=rightcoord[0];
    		coord[7]=rightcoord[1];
    	}
    	return coord;
    }
    /*
     * This method  receives an array with the coordinates of the fields for available movements,
     * an two integers that are the coordinates of the movement done
     */
    public int[] updateBoardonMove(int[]mov, int x, int y){
    	if(mov[0]==x && mov[1]==y){
    		upMove(x,y);
    		pegsToChange[0] = x+2;
    		pegsToChange[1] = y;
    		pegsToChange[2] = x+1;
    		pegsToChange[3] = y;
    		pegsToChange[4] = x;
    		pegsToChange[5] = y;
    		mov[0]=0;
    		mov[1]=0;
    	}if(mov[2]==x && mov[3]==y){
    		downMove(x,y);
    		pegsToChange[0] = x-2;
    		pegsToChange[1] = y;
    		pegsToChange[2] = x-1;
    		pegsToChange[3] = y;
    		pegsToChange[4] = x;
    		pegsToChange[5] = y;
    		mov[2]=0;
    		mov[3]=0;
    	}if(mov[4]==x && mov[5]==y){
    		leftMove(x,y);
    		pegsToChange[0] = x;
    		pegsToChange[1] = y+2;
    		pegsToChange[2] = x;
    		pegsToChange[3] = y+1;
    		pegsToChange[4] = x;
    		pegsToChange[5] = y;
    		mov[4]=0;
    		mov[5]=0;
    	}if(mov[6]==x && mov[7]==y){
    		rightMove(x,y);
    		pegsToChange[0] = x;
    		pegsToChange[1] = y-2;
    		pegsToChange[2] = x;
    		pegsToChange[3] = y-1;
    		pegsToChange[4] = x;
    		pegsToChange[5] = y;
    		mov[6]=0;
    		mov[7]=0;
    	}else{
    		undoSelect(mov);
    	}
    	return pegsToChange;
    }
    public void upMove(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.X)){
    		board.setFieldOwner(Symbol.O, x, y);
    		board.setFieldOwner(Symbol.NONE, x+1, y);
    		board.setFieldOwner(Symbol.NONE, x+2, y);
    	}
    }
    public void downMove(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.X)){
    		board.setFieldOwner(Symbol.O, x, y);
    		board.setFieldOwner(Symbol.NONE, x-1, y);
    		board.setFieldOwner(Symbol.NONE, x-2, y);
    	}
    }
    public void leftMove(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.X)){
    		board.setFieldOwner(Symbol.O, x, y);
    		board.setFieldOwner(Symbol.NONE, x, y+1);
    		board.setFieldOwner(Symbol.NONE, x, y+2);
    	}
    }
    public void rightMove(int x, int y){
    	if(board.getFieldOwner(x, y).equals(Symbol.X)){
    		board.setFieldOwner(Symbol.O, x, y);
    		board.setFieldOwner(Symbol.NONE, x, y-1);
    		board.setFieldOwner(Symbol.NONE, x, y-2);
    	}
    }
    public void undoSelect(int[] x){
    	board.setFieldOwner(Symbol.NONE, x[0], x[1]);
    	board.setFieldOwner(Symbol.NONE, x[2], x[3]);
    	board.setFieldOwner(Symbol.NONE, x[4], x[5]);
    	board.setFieldOwner(Symbol.NONE, x[6], x[7]);
    }
    //This method compares the fields involved in the upside movement of a peg 
    public void validateUp(int x, int y){
    	if(x>1){
	    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x-1, y).equals(Symbol.O) && board.getFieldOwner(x-2, y).equals(Symbol.NONE)){
	    		board.setFieldOwner(Symbol.X, x-2, y);
	    		upcoord[0]=x-2;
	    		upcoord[1]=y;
	    	}else{
	    		upcoord[0]=0;
	    	}
    	}
    }
  //This method compares the fields involved in the downside movement of a peg 
    public void validateDown(int x, int y){
    	if(x<5){
	    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x+1, y).equals(Symbol.O) && board.getFieldOwner(x+2, y).equals(Symbol.NONE)){
	    		board.setFieldOwner(Symbol.X, x+2, y);
	    		downcoord[0]=x+2;
	    		downcoord[1]=y;
	    	}else{
	    		downcoord[0]=0;
	    	}
    	}
    }
  //This method compares the fields involved in the left side movement of a peg 
    public void validateLeft(int x, int y){
    	if(y>1){
	    	if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y-1).equals(Symbol.O) && board.getFieldOwner(x, y-2).equals(Symbol.NONE)){
	    		board.setFieldOwner(Symbol.X, x, y-2);
	    		leftcoord[0]=x;
	    		leftcoord[1]=y-2;
	    	}else{
	    		leftcoord[0]=0;
	    	}
    	}
    }
  //This method compares the fields involved in the left side movement of a peg 
    public void validateRight(int x, int y){
    	if(y<5){
    		if(board.getFieldOwner(x, y).equals(Symbol.O)&& board.getFieldOwner(x, y+1).equals(Symbol.O) && board.getFieldOwner(x, y+2).equals(Symbol.NONE)){
        		board.setFieldOwner(Symbol.X, x, y+2);
        		rightcoord[0]=x;
        		rightcoord[1]=y+2;
        	}else{
        		rightcoord[0]=0;
        	}
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
    	boolean bool;
        if (pegsCounter == 1 && board.getFieldOwner(3, 3).equals(Symbol.O)) bool=true; else bool=false;
        return bool;
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

	public int[] getUpcoord() {
		return upcoord;
	}

	public int[] getDowncoord() {
		return downcoord;
	}

	public int[] getLeftcoord() {
		return leftcoord;
	}

	public int[] getRightcoord() {
		return rightcoord;
	}
}