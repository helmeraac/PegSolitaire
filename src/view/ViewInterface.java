	package view;

import model.Field.Symbol;


public interface ViewInterface
{
	/**
     * Changes a field to a user symbol.
     * 
     * @param symbol    the symbol of the current player.
     * @param button    the button that was clicked.
     */
    public void buildBoard();
    
    /**
     * Changes a field to a user symbol.
     * 
     * @param symbol    the symbol of the current player.
     * @param button    the button that was clicked.
     */
    public void updateBoardOnSelect(int[] oldButtons, int[] newButtons);
    
    /**
     * Changes a field on selected button.
     * 
     * @param buttons    the button that was clicked.
     */
    public void updateBoardOnMove(int[] buttons);
    
    /**
     * Informs the user who won.
     * 
     * @param symbol    the symbol of the current player (=> winner).
     */
    public void informWin(Symbol userSymbol);
    
    /**
     * Informs the user of the tie.
     */
    public void informTie();

	public void changeCounter(int i);
}
