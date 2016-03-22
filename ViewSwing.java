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
	public static void main(String[] args)
	{
		//Size of Window
		final int FRAME_WIDTH = 1000; 
		final int FRAME_HEIGHT = 1000; 
		
		//Create the model object for the connect four class
		//int dimension = Integer.parseInt(args[0]);	
		int dimension = 10;
		
		boolean win = false;
		
		final Model m = new Model(dimension);
		int[][] board = m.getTable();
		
		//Make Connect four frame
		JFrame container = new JFrame("Connect 4");
		container.setLayout(new GridLayout(dimension + 1, dimension, 5, 5));
		
		JLabel[][] buttonNames = new JLabel[dimension][dimension];
		JButton[] buttons = new JButton[dimension];
		
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JButton();
			buttons[i].setActionCommand("" + i);
			
			class ButtonListener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{
					int xposition = Integer.parseInt(event.getActionCommand());
					
					if (!win && !m.isFullColumn(xposition))
					{
						
					}
				}
			}
			
			buttons[i].addActionListener(new ButtonListener());			
		}
		
		for (int i = 0; i < buttonNames.length; i++)
		{
			for (int j = 0; j < buttonNames.length; j++)
			{
				buttonNames[i][j] = new JLabel(new ImageIcon("Rectangle.png"));
			}
		}
		
		for (int i = 0; i < buttonNames.length; i++)
		{
			for (int j = 0; j < buttonNames.length; j++)
			{
				container.add(buttonNames[i][j]);
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
