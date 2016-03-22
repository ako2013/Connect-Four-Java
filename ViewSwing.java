import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		//int dimension = Integer.parseInt(args[0]);	
		int dimension = 10;

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
					int yposition = xposition;
					
					m.insertBoard(xposition, m.getPlayer());
					
					if (m.getWinning() == 0 && !m.isDraw())
					{
						for(int i = 0; i < dimension; i ++)
						{
						
							if (images[xposition][yposition].getIcon().equals(UNSET))
							{
								if (m.getPlayer() == 1)
								{
									images[xposition][yposition].setIcon(BLUE);
								}
								else
								{
									images[xposition][yposition].setIcon(RED);
								}
							}
						}
						m.turn();
						redraw(container);
					}
					else if(m.isDraw())
					{
						JOptionPane.showMessageDialog(container, "Game is a Draw!");
					}
					else if(m.getWinning() == 1)
					{
						JOptionPane.showMessageDialog(container, "Player 1 Wins!");
					}
					else
					{
						JOptionPane.showMessageDialog(container, "Player 2 Wins!");
					}
				}
			}
			
			buttons[i].addActionListener(new ButtonListener());			
		}
		
		for (int i = 0; i < images.length; i++)
		{
			for (int j = 0; j < images.length; j++)
			{
				images[i][j] = new JLabel(new ImageIcon("Rectangle.png"));
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

	private void redraw(JFrame frame) 
	{
		frame.removeAll();
		for (int i = 0; i < images.length; i++)
		{
			for (int j = 0; j < images.length; j++)
			{
				frame.add(images[i][j]);
			}
		}
		for (JButton x: buttons)
		{
			frame.add(x);
		}
		
	}

}
