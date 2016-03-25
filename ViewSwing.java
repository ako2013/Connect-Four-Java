import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This ViewSwing class creates a
 * @author Hezekiah Valdez and Ravuth Long
 *
 */
public class ViewSwing 
{	
	
	private static final ImageIcon UNSET = new ImageIcon("Rectangle.png"); 
	private static final ImageIcon RED = new ImageIcon("Red.png"); 
	private static final ImageIcon BLUE = new ImageIcon("Blue.png"); 
	private Model m;
	private int dimension;
	private int winningSize;
	private JLabel[][] images;
	private JButton[] buttons;
	
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
	
	private void draw()
	{
	
		//Size of Window
		final int FRAME_WIDTH = 1000; 
		final int FRAME_HEIGHT = 1000; 
		
		//Create the model object for the connect four class
		
		//Make Connect four frame
		JFrame container = new JFrame("Connect 4");
		container.setLayout(new GridLayout(dimension + 1, dimension, 5, 5));
		
		
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JButton();
			buttons[i].setActionCommand("" + i);
			
			class ButtonListener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{
					int xposition = Integer.parseInt(event.getActionCommand());
					int[][] board = m.getTable();					
					
					int winCondition =  m.insertBoard(xposition, m.getPlayer());
					
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
					m.turn();
					if(winCondition == 1)
					{
						JOptionPane.showMessageDialog(container, "Player " + m.getPlayer() + " Wins!");
						
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
		
		for (int i = 0; i < images.length; i++)
		{
			for (int j = 0; j < images.length; j++)
			{
				images[i][j] = new JLabel(UNSET);
			}
		}
		
		for (int i = 0; i < images.length; i++)
		{
			for (int j = 0; j < images.length; j++)
			{
				container.add(images[i][j]);
			}
		}
		
		for (JButton x: buttons)
		{
			container.add(x);
		}
		
		
		//Generic JFrame Options
		container.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setVisible(true);
		
	}


}
