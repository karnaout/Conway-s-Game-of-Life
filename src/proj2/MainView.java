/*
 * Khaled Arnaout
 * Project 2 
 * MainView 
 */
package proj2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

/**
 * The main view is a class where I connect all view elements together
 */
public class MainView extends JPanel implements Observer {
	
	private Labels labels;
	private Buttons buttons;
	private Canvas canvas;

	
	public MainView() {
		// Initialize the label, canvas, and buttons
		this.labels = new Labels();
		this.buttons = new Buttons();
		this.canvas = new Canvas();

		// Create JScrollPanel with the canvas 
		// allowing user to scroll the canvas
		// Also set size of the scroll panel
		JScrollPane canvaspanel = new JScrollPane(canvas);
		canvaspanel.setMinimumSize(new Dimension(500,400));
		canvaspanel.setPreferredSize(new Dimension(600,400));
		canvaspanel.setMaximumSize(new Dimension(500,400));
		// Set the layout and size of this panel
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(new Dimension(500,550));
		this.setPreferredSize(new Dimension(800,600));
		this.setMaximumSize(new Dimension(500,550));
		// Set constraint
		GridBagConstraints constraint = new GridBagConstraints();
		// Location where first component will be added
		constraint.gridx = 0;
		constraint.gridy = 0;
		// Don't stretch components to fill this panel
		constraint.fill = GridBagConstraints.NONE;
		// Add components from top to bottom
		this.add(canvaspanel, constraint);
		constraint.gridy = 1;
		this.add(buttons, constraint);
		this.add(labels,constraint);
	}
	
	/**
	 * This method runs the setStartlistener method in the button class
	 * which will set the ActionListener that it takes as input 
	 * to the appropriate button
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			act is the actionListener to the start button  
	 */
	public void setStartListener(ActionListener act) {
		this.buttons.setStartlistener(act);
	}
	
	/**
	 * This method runs the setResetlistener method in the Button class
	 * which will set the ActionListener act to the reset button
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			act is the actionListener to the reset button  
	 */
	public void setResetListener(ActionListener act) {
		this.buttons.setResetlistener(act);
	}
	
	/**
	 * adds the MouseListener act to the canvas
	 * which will set the ActionListener act to the reset button
	 * @param act is the Mouse Action Listener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			act is the mouse actionListener on the canvas  
	 */
	public void setMouseListener(MouseListener act) {
		this.canvas.addMouseListener(act);
	}
	
	/**
	 * This method runs the setStartRandomlistener method in the Button class
	 * which will set the ActionListener act to the startRandom button
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			act is the actionListener to the startRandom button  
	 */
	public void setStartRanListener(ActionListener act) {
		this.buttons.setStartReslistener(act);
	}
	
	/**
	 * This method runs the setRadioButtonslistener method in the Button class
	 * which will set the ActionListener act to the radio buttons
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			radio buttons are now observed by act   
	 */
	public void setRadioButtonslistener(ActionListener act) {
		this.buttons.setRadioButtonslistener(act);
	}
	
	/**
	 * This method runs the setSliderListener method in the Button class
	 * which will set the ActionListener act to the slide bar
	 * @param act is the actionListener
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			slider bar is now observed by act  
	 */
	public void setSliderListener(ChangeListener act){
		this.buttons.setSliderListener(act);
	}
	
	/**
	 * returns the button is pushed 
	 * @param act is the actionListener
	 * @return 1 if the first radio button is pushed
	 * 		   2 if the second radio button is pushed
	 * 	   	   3 if the third radio button is pushed
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none   
	 */
	public int buttonPushed(){
		return this.buttons.pushedButton();
	}
	
	/**
	 * This method runs the setcanvasSize method in the canvas class
	 * which will set the size of the canvas to the appropriate size
	 * @param x the integer determines which button is pushed
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the size of the canvas is now changed to the appropriate size 
	 */
	public void setcanvasSize(int x){
		this.canvas.setcanvasSize(x);
	}
	
	/**
	 * This method runs the getSliderValue method in the Button class
	 * which will return the value of the slider 
	 * @return return integer number of the current slider value
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			none
	 */
	public int getSliderValue(){
		return this.buttons.getSliderValue();
	}
		
	/**
	 * This method runs the updatecounter method that is in the label class
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the counter is now updated  
	 */
	public void updatecounter() {
		this.labels.updatecounter();
	}
	
	/**
	 * This method runs the resetcounter method that is in the label class
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the counter is now reset  
	 */
	public void resetcounter() {
		this.labels.resetcounter();
	}
	
	/**
	 * runs the addloc method that is in the canvas class which will add 
	 * the point loc to the points in the canvas
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the point loc is now added to the canvas points  
	 */
	public void addloc(Point loc) {
		this.canvas.addloc(loc);
	}
	
	/**
	 * runs the removeloc method that is in the canvas class which will remove 
	 * the point loc to from the points in the canvas
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the point loc is now removed from the canvas points  
	 */
	public void removeloc(Point loc) {
		this.canvas.removeloc(loc);
	}
	
	/**
	 * runs the removeall method that is in the canvas class which will remove 
	 * all the point in the canvas
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the canvas is now empty  
	 */
	public void removeall() {
		this.canvas.removeall();
	}
	
	/**
	 * runs the setNumAlive method that is in the label class which will give
	 * it the number of locs that are in the canvas, in order to set the number 
	 * of alive cells on the appropriate label.
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the number of alive cells is now set on the label
	 */
	public void setNumbAlive() {
		this.labels.setNumAlive(this.canvas.numbLocs());
	}
	
	/**
	 * repaints the canvas
	 * @param none
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the canvas is now repainted
	 */
	public void draw() {
		this.canvas.repaint();
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
	public void flip(){
		this.buttons.flip();
	}
	
	/**
	 * runs the setSquareSize method that is in the canvas class which will 
	 * set the size of every square in the canvas
	 * @param size is the size 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the size of the square is now = size
	 */
	public void setSquareSize(int size){
		this.canvas.setSquareSize(size);
	}
	
	/**
	 * runs the getSqaureSize method that is in the canvas class which will 
	 * get the size of the square in the canvas
	 * @param size is the size 
	 * @return none
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			the size of the square is now = size
	 */
	public int getSquareSize(){
		return this.canvas.getSqaureSize();
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
		this.buttons.Randomflip();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof ArrayList<?>) {
			ArrayList<Point> locs = (ArrayList<Point>) arg;
			this.canvas.setlocs(locs);
			this.canvas.repaint();
		}
	}
}



