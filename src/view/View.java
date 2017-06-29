package view;

import model.Field.Symbol;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JFrame implements ViewInterface {
    private final GridLayout grid;     // default grid-size for tic-tac-toe
    private final JButton[] buttons;   // an array containing the 9 buttons
    private int[] disabledFields = {0,1,5,6,7,8,12,13,35,36,40,41,42,43,47,48};

    public View() {
        super("Peg Solitaire");
        grid = new GridLayout(7, 7);
        buttons = new JButton[49];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);
        
        buildBoard();

        //getRootPane().setDefaultButton(buttons[4]);
        //buttons[4].requestFocus();
    }

    /**
     * Adds the panel along with its buttons to the pane.
     */
    public void addComponentsToPane(final Container pane) {
        final JPanel panel = new JPanel();
        panel.setLayout(grid);        
        panel.setPreferredSize(new Dimension(400, 400));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].getPreferredSize();
            panel.add(buttons[i]);
        }

        pane.add(panel);
    }

    @Override
    /**
     * Changes a field to a user symbol.
     * 
     * @param symbol    the symbol of the current player.
     * @param button    the button that was clicked.
     */
    public void updateBoard(Symbol userSymbol, JButton button) {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/" + userSymbol.toString() + ".png"));
            button.setIcon(new ImageIcon(icon));
            button.setEnabled(false);
        } catch (IOException ex) {
            System.out.println("icons/" + userSymbol.toString() + ".png not found.");
        }
    }

    /**
     * Informs the user who won.
     * 
     * @param symbol    the symbol of the current player (=> winner).
     */
    @Override
    public void informWin(Symbol userSymbol) {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }

        JOptionPane.showMessageDialog(null, "Player " + userSymbol.toString() + " has won!");
    }

    /**
     * Informs the user of the tie.
     */
    @Override
    public void informTie() {
        JOptionPane.showMessageDialog(null, "Tie!");
    }

    /**
     * Returns a button with a specific index.
     * 
     * @return a button with a specific index.
     */
    public JButton getButton(int index) {
        return buttons[index];
    }

    /**
     * Returns the size of the buttons[] array.
     * 
     * @return the size of the buttons[] array.
     */
    public int getNumberOfButtons() {
        return buttons.length;
    }

	@Override
	public void buildBoard() {
		for (JButton button : buttons) {
			try {
				Image icon = ImageIO.read(View.class.getResource("icons/O.png"));
				button.setIcon(new ImageIcon(icon));
		        button.setEnabled(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
		for (int i : disabledFields) {
			try {
				Image icon = ImageIO.read(View.class.getResource("icons/X.png"));
				buttons[i].setIcon(new ImageIcon(icon));
		        buttons[i].setEnabled(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
		buttons[24].setIcon(null);

	}
}