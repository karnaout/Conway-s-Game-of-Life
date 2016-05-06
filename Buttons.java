/*
 * Khaled Arnaout
 * Project 2 
 * Buttons 
 */
package proj2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Buttons extends JPanel {
	
	private static final long serialVersionUID = -3360972525436693748L;
	private JButton start,stop,reset;
					

	public Buttons(){
		// Initialize the buttons
		// Add their text
		start = new JButton();
		start.setText("Start");
		stop = new JButton();
		stop.setText("Stop");
		reset = new JButton();
		reset.setText("Reset");

		
		// Create layout and its size
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		this.setPreferredSize(new Dimension(350,100));
		this.setMaximumSize(new Dimension(350,100));
		this.setMinimumSize(new Dimension(350,100));
		layout.setVgap(15); // Set gap
		this.setLayout(layout); // Set the layout
		
		// Add the buttons
		this.add(start);
		this.add(reset);
		this.add(stop);
	}
	
	/**
	 * sets the ActionListener to the start button 
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			start button is now observed by act   
	 */
	public void setStartlistener(ActionListener act) {
		start.addActionListener(act);
	}
	
	/**
	 * sets the ActionListener to the stop button 
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			stop button is now observed by act   
	 */	
	public void setStoplistener(ActionListener act) {
		stop.addActionListener(act);
	}
	
	/**
	 * sets the ActionListener to the reset button 
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			reset button is now observed by act   
	 */
	public void setResetlistener(ActionListener act) {
		reset.addActionListener(act);
	}
}
