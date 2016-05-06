/*
 * Khaled Arnaout
 * Project 2 
 * Buttons 
 */
package proj2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

/**
 * This class represents all the buttons appear on the screen
 */
public class Buttons extends JPanel {
	
	private JButton start,reset,startran;
	private ButtonGroup group;
	private JRadioButton Grid450X390,Grid800X800,Grid1000X1000;
	private JSlider slider;

	public Buttons(){
		// Initialize the buttons
		// Add their text
		this.start = new JButton();
		this.start.setText("Start");
		this.reset = new JButton();
		this.reset.setText("Reset");
		this.startran = new JButton();
		this.startran.setText("Start Random filling");
		this.Grid450X390 = new JRadioButton("450X390", true);
		this.Grid800X800 = new JRadioButton("800X800 ", false);
		this.Grid1000X1000 = new JRadioButton("1000X1000 ", false);
		this.group = new ButtonGroup();
		this.slider = new JSlider();
		
		// Create layout and its size
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		this.setPreferredSize(new Dimension(350,150));
		this.setMaximumSize(new Dimension(350,150));
		this.setMinimumSize(new Dimension(350,100));
		layout.setVgap(15); 
		this.setLayout(layout); 
		this.slider.setValue(10);
		this.slider.setToolTipText("");
		this.slider.setMaximum(50);
		this.slider.setMinimum(10);
		// Add the buttons
		this.add(start);
		this.add(reset);
		this.add(startran);
		this.add(Grid450X390);
		this.add(Grid800X800);
		this.add(Grid1000X1000);
		this.add(slider);
		
		group.add(Grid450X390);
		group.add(Grid800X800);
		group.add(Grid1000X1000);
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
		this.start.addActionListener(act);
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
		this.reset.addActionListener(act);
	}
	
	/**
	 * sets the ActionListener to the startRandom button 
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			reset button is now observed by act   
	 */
	public void setStartReslistener(ActionListener act) {
		this.startran.addActionListener(act);
	}
	
	/**
	 * sets the ActionListener to the radio buttons 
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			radio buttons are now observed by act   
	 */
	public void setRadioButtonslistener(ActionListener act) {
		this.Grid450X390.addActionListener(act);
		this.Grid800X800.addActionListener(act);
		this.Grid1000X1000.addActionListener(act);
	}
	
	/**
	 * sets the ActionListener to the radio buttons 
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			radio buttons are now observed by act   
	 */
	public void setSliderListener(ChangeListener act) {
		this.slider.addChangeListener(act);
	}
	
	/**
	 * Determines which button is selected by retruning an integer number 
	 * @param none
	 * @return return 1 if the button Grid450X390 is selected 
	 * 		   return 2 if the button Grid800X800 is selected
	 * 		   return 3 if the button Grid1000X1000 is selected 
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none   
	 */
	public int pushedButton(){
		if(Grid450X390.isSelected())
			return 1;
		else if(Grid800X800.isSelected())
			return 2;
		else
			return 3;
	}
	
	/**
	 * Flips the label of the start/stop button
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the label of the start/stop button is now flipped
	 */
	
	/**
	 * returns the value of the slider
	 * @return return integer number of the current slider value
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public int getSliderValue(){
		return this.slider.getValue();
	}
	
	public void flip(){
		if( this.start.getText()=="Start" ){
			this.start.setText("Stop");
		}
		else{
			this.start.setText("Start");
		}
	}
	
	/**
	 * Flips the label of the startRandom/stopRandom button
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the label of the startRandom/stopRandom button is now flipped
	 */
	public void Randomflip(){
		if( this.startran.getText()=="Start Random filling" ){
			this.startran.setText("Stop Random filling");
		}
		else{
			this.startran.setText("Start Random filling");
		}
	}
}
