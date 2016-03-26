
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This ViewSwing class creates a GUI for a user to interact with. 
 * @author Hezekiah Valdez and Ravuth Long
 *
 */
public class ViewSwing 
{	
	//The three image files that are used
	private static final ImageIcon UNSET = new ImageIcon("Rectangle.png"); 
	private static final ImageIcon RED = new ImageIcon("Red.png"); 
	private static final ImageIcon BLUE = new ImageIcon("Blue.png"); 
	
	//Variables that are directly linked to the board
	private Model m;
	private int dimension;
	private int winningSize;
	
	//The arrays of the images as well as the buttons
	private JLabel[][] images;
	private JButton[] buttons;
	
	/**
	 * Constructor for the ViewSwing class
	 * @param dimension The desired size of the array.
	 * @param winningSize The desired amount of connections required for vicotry
	 */
	public ViewSwing(int dimension, int winningSize)
	{
		this.dimension = dimension;
		this.winningSize = winningSize;
		//Array of images and array of buttons
		images = new JLabel[dimension][dimension];
		buttons = new JButton[dimension];
		m = new Model(dimension, winningSize);
		draw();
	}
	
	/**
	 * A method that uses Java Swing to draw a GUI to interact with the board
	 */
	private void draw()
	{
	
		//Size of Window
		final int FRAME_WIDTH = 1000; 
		final int FRAME_HEIGHT = 1000; 
	
		
		//Make Connect four frame
		JFrame container = new JFrame("Connect 4");
		container.setLayout(new GridLayout(dimension + 1, dimension, 5, 5));
		
		//Create the number of buttons equal to the size of the board
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JButton();
			//Tell the buttons what number they are
			buttons[i].setActionCommand("" + i);
			
			class ButtonListener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{
					int xposition = Integer.parseInt(event.getActionCommand());
					int[][] board = m.getTable();					
					
					//Add the spot to the board
					int winCondition =  m.insertBoard(xposition, m.getPlayer());
					
					//Check the current column and check to see which spots to change
					for(int i = 0; i < m.getSize(); i ++)
					{
						if(board[xposition][i] == 1)
						{
							images[m.getSize() - 1 - i][xposition].setIcon(BLUE);
						}
						if(board[xposition][i] == 2)
						{
							images[m.getSize() - 1 - i][xposition].setIcon(RED);
						}
					}
					//Change the current turn counter
					m.turn();
					//Options depending on whether a player has won, the game is a draw, or the column is full.
					if(winCondition == 1)
					{
						int selectedOption = JOptionPane.showConfirmDialog(null, "Player " + m.getPlayer() + " Wins! \n" + "Play again?", "Congratulations", JOptionPane.YES_NO_CANCEL_OPTION);
						if(selectedOption == JOptionPane.YES_OPTION)
						{
							m = new Model(dimension, winningSize);
							draw();
						}
						
					}
					if(winCondition == 2) 
					{
						JOptionPane.showMessageDialog(container, "Column is full please choose again");
						m.turn();
					}
					if(m.isDraw())
					{
						JOptionPane.showMessageDialog(container, "Game is a draw");
					}
					
				}
			}
			
			buttons[i].addActionListener(new ButtonListener());			
		}
		
		//Sets the color for all of the labels
		for (int i = 0; i < images.length; i++)
		{
			for (int j = 0; j < images.length; j++)
			{
				images[i][j] = new JLabel(UNSET);
			}
		}
		
		//Adds the labels to the frame
		for (int i = 0; i < images.length; i++)
		{
			for (int j = 0; j < images.length; j++)
			{
				container.add(images[i][j]);
			}
		}
		
		//Add the buttons to the frams
		for (JButton x: buttons)
		{
			container.add(x);
		}
		
		
		//Generic JFrame Options setting the visibility, dimensions, and close options
		container.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setVisible(true);
		
	}


}
