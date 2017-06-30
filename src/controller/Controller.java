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
    public int oldmovements[];
    public int newmovements[];
    
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
        addActionListeners();
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
        if (!game.isGameOver(game.getUserSymbol())) {
        	int indexOfViewButton = getJButtonIndex((JButton) e.getSource());
            Pair coordinates = convertToCoordinates(indexOfViewButton);
            for(int i=0;i<4;i++){
            oldmovements[i]=newmovements[i];
            }
            game.validateMovement(game.getUserSymbol(),coordinates.first, coordinates.second);
            newmovements[0]= indexOfViewButton-14;
            newmovements[1]= indexOfViewButton+14;
            newmovements[2]= indexOfViewButton+2;
            newmovements[3]= indexOfViewButton-2;
            for(int i=1;i<4;i++){
            	if(indexOfViewButton==oldmovements[i]){
            		
            		view.updateBoardOnMove(newmovements);//TODO
            	}else{
            		view.updateBoardOnSelect(oldmovements, newmovements);
            	}
            }

            game.incTurnCounterAndSetUserSymbol();

            // The indices of the View JButton array is 0-8 while the
            // indices of the Game Field array
            // is a 2d 3x3 array, so I have to convert the index
            // into x- and y- coordinates.
            game.setFieldOwner(game.getUserSymbol(),
                               coordinates.first,
                               coordinates.second);

            //view.updateBoard(game.getUserSymbol(), (JButton) e.getSource());
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
        int first = 0;
        int second = 0; // forced initialization

        switch (index) {
            case 0: first = 0; second = 0; break;
            case 1: first = 0; second = 1; break;
            case 2: first = 0; second = 2; break;
            case 3: first = 0; second = 3; break;
            case 4: first = 0; second = 4; break;
            case 5: first = 0; second = 5; break;
            case 6: first = 0; second = 6; break;
            case 7: first = 1; second = 0; break;
            case 8: first = 1; second = 1; break;
            case 9: first = 1; second = 2; break;
            case 10: first = 1; second = 3; break;
            case 11: first = 1; second = 4; break;
            case 12: first = 1; second = 5; break;
            case 13: first = 1; second = 6; break;
            case 14: first = 2; second = 0; break;
            case 15: first = 2; second = 1; break;
            case 16: first = 2; second = 2; break;
            case 17: first = 2; second = 3; break;
            case 18: first = 2; second = 4; break;
            case 19: first = 2; second = 5; break;
            case 20: first = 2; second = 6; break;
            case 21: first = 3; second = 0; break;
            case 22: first = 3; second = 1; break;
            case 23: first = 3; second = 2; break;
            case 24: first = 3; second = 3; break;
            case 25: first = 3; second = 4; break;
            case 26: first = 3; second = 5; break;
            case 27: first = 3; second = 6; break;
            case 28: first = 4; second = 0; break;
            case 29: first = 4; second = 1; break;
            case 30: first = 4; second = 2; break;
            case 31: first = 4; second = 3; break;
            case 32: first = 4; second = 4; break;
            case 33: first = 4; second = 5; break;
            case 34: first = 4; second = 6; break;
            case 35: first = 5; second = 0; break;
            case 36: first = 5; second = 1; break;
            case 37: first = 5; second = 2; break;
            case 38: first = 5; second = 3; break;
            case 39: first = 5; second = 4; break;
            case 40: first = 5; second = 5; break;
            case 41: first = 5; second = 6; break;
            case 42: first = 6; second = 0; break;
            case 43: first = 6; second = 1; break;
            case 44: first = 6; second = 2; break;
            case 45: first = 6; second = 3; break;
            case 46: first = 6; second = 4; break;
            case 47: first = 6; second = 5; break;
            case 48: first = 6; second = 6; break;
            default: break;
        }

        return Pair.create(first, second);
    }


    /**
     * Calls the isGameOver function in the Game class.
     * 
     * @return      returns true if game is over. Returns false if otherwise.
     */
    public boolean isGameOver() {
        return game.isGameOver(game.getUserSymbol());
    }
}