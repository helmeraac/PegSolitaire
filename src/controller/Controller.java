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
    public int newcoords[];
    
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
        newmovements= new int[8];
        oldmovements= new int[4];
        newcoords = new int[8];
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
        if (!game.isGameOver()) {
        	int indexOfViewButton = getJButtonIndex((JButton) e.getSource());
            Pair coordinates = convertToCoordinates(indexOfViewButton);
            for(int i=0;i<4;i++){
            oldmovements[i]=newmovements[i];
            }
            newmovements=game.validateMovement(coordinates.first, 
            		                           coordinates.second);

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
        int first = 0;
        int second = 0; // forced initialization

        switch (index) {
            case 2: first = 0; second = 2; break;
            case 3: first = 0; second = 3; break;
            case 4: first = 0; second = 4; break;
            case 9: first = 1; second = 2; break;
            case 10: first = 1; second = 3; break;
            case 11: first = 1; second = 4; break;
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
            case 37: first = 5; second = 2; break;
            case 38: first = 5; second = 3; break;
            case 39: first = 5; second = 4; break;
            case 44: first = 6; second = 2; break;
            case 45: first = 6; second = 3; break;
            case 46: first = 6; second = 4; break;
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
        return game.isGameOver();
    }
}