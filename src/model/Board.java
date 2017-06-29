package model;

import model.Field.Symbol;


public class Board {
	private Field[][] gameGrid;
    private static final int BOARD_SIDE_LENGTH = 7;
    //Standard configuration board
    public Board() {
        gameGrid = new Field[BOARD_SIDE_LENGTH][BOARD_SIDE_LENGTH];
        
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int j = 0; j < BOARD_SIDE_LENGTH; j++) {
                if((i <= 1 && j <=1)||(i <= 1 && j >=5)||(i >= 5 && j <=1)||(i >= 5 && j >=5)||(i == 3 && j == 3)){
                	gameGrid[i][j] = Field.getNone();
                }else
                gameGrid[i][j] = Field.getDefault();
            }
        }
    }
    public void setFieldOwner(Symbol owner, int x, int y) {
        gameGrid[x][y].setOwner(owner);
    }
    public Symbol getFieldOwner(int x, int y) {
        return gameGrid[x][y].getOwner();
    }
}
