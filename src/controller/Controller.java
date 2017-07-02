package controller;

import model.Game;
import utils.Pair;
import view.View;
import view.ViewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
    private Game game;
    private ViewInterface view;
    private int[] oldmovements;
    private int[] newmovements;
    private int[] coord;
    private int[] pegsToMove;
    private int[] oldCoord;
    
    /**
     * Overloaded constructor. Initializes the game and view, and
     * adds the action listeners to the buttons in view.
     * 
     * @param   an instance of the Game class.
     * @param   an instance of the View class.
     */
    public Controller() {
        this.game = new Game();
        this.view = new View();
        newmovements= new int[4];
        oldmovements= new int[4];
        pegsToMove = new int[3];
        oldCoord = new int[8];
        coord= new int[8];
        addActionListeners();
        for(int i=0;i<coord.length;i++){
        	coord[i]=0;
        }
    }

    /**
     * Adds an action listener to every button.
     */
    private void addActionListeners() {
        for (int i = 0; i < ((View)view).getNumberOfButtons(); i++) {
            ((View)view).getButton(i).addActionListener(this);
        }
    }

    /**
     * Increments the number of moves since the start of the game, and
     * sets the user symbol. It then finds out what x and y coordinates that button
     * corresponds to in the Game object.
     * Examples: button[0] would be Field[0][0]. button [1] would be Field[0][1].
     * button[5] would be Field[1][2].
     * 
     * It then sets the owner of the field in the Game object, and modifies the View buttons.
     * 
     * @param e     the action performed. In this game, it would be a mouse click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!game.isGameOver()) {
        	int indexOfViewButton = getJButtonIndex((JButton) e.getSource());
            Pair coordinates = convertToCoordinates(indexOfViewButton);
            
            coord=game.validateMovement(coordinates.first, 
            		                    coordinates.second);
            for(int i = 0; i < 4; i++){
            	if(oldmovements[i] == indexOfViewButton){
            		int [] pegsCoords = game.updateBoardonMove(oldCoord,coordinates.first, 
		                    coordinates.second);
            		pegsToMove[0] = convertToIndex(pegsCoords[0],pegsCoords[1]);
            		pegsToMove[1] = convertToIndex(pegsCoords[2],pegsCoords[3]);
            		pegsToMove[2] = convertToIndex(pegsCoords[4],pegsCoords[5]);
            		
            		view.updateBoardOnMove(pegsToMove);
            		oldmovements[i] = 0;
            	}
            }
            for(int i=0;i<8;i++){
            	oldCoord[i]=coord[i];
            }
            
            newmovements[0]=convertToIndex(coord[0],coord[1]);
            newmovements[1]=convertToIndex(coord[2],coord[3]);
            newmovements[2]=convertToIndex(coord[4],coord[4]);
            newmovements[3]=convertToIndex(coord[6],coord[7]);
            
            view.updateBoardOnSelect(oldmovements, newmovements);
            
            for(int i=0;i<4;i++){
            	oldmovements[i]=newmovements[i];
            }
            
            game.incTurnCounterAndSetUserSymbol();
        }
    }

    /**
     * Returns the index of the current JButton.
     * 
     * @param button    the button that was clicked.
     * @return      the [0-8] index of the JButton clicked.
     */
    private int getJButtonIndex(JButton button) {
        int buttonIndex = 0;
        for (int i = 0; i < 49; i++) {
            if (button == ((View)view).getButton(i)) {
                buttonIndex = i;
            }
        }
        return buttonIndex;
    }

    /**
     * Returns a pair containing the x and y coordinates corresponding to the View buttons array [0-8 index].
     *
     * @param index     index of the view button.
     * @return          a Pair object containing the x and y coordinates.
     */
    private Pair convertToCoordinates(int index) {
    	int first = index/7;
    	int second = index%7;
        return Pair.create(first, second);
    }
    
    private int convertToIndex(int x, int y){
    	return((x*7)+y);
    }


    /**
     * Calls the isGameOver function in the Game class.
     * 
     * @return      returns true if game is over. Returns false if otherwise.
     */
    public boolean isGameOver() {
        return game.isGameOver();
    }
}