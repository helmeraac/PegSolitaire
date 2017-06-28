package model;

import model.Field.Symbol;


public class Board {
	private Field[][] gameGrid;
    private static final int BOARD_SIDE_LENGTH = 7;
    //Latin Cross board
    public Board() {
        gameGrid = new Field[BOARD_SIDE_LENGTH][BOARD_SIDE_LENGTH];
        
        for (int j = 1; j <= 4; j++){
        	gameGrid[3][j] = Field.getDefault();
        }
        
        gameGrid[2][2] = Field.getDefault();
        gameGrid[4][2] = Field.getDefault();
    }
}
