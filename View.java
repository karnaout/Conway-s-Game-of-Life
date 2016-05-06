/*
 * Khaled Arnaout
 * Project 2 
 * View 
 */
package proj2;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class View extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Labels labels;
	private Buttons buttons;
	private Canvas canvas;
	
	public View() {
		// Initialize the panel, label, canvas, and buttons
		this.labels = new Labels();
		this.buttons = new Buttons();
		this.canvas = new Canvas();
		// Create JScrollPanel with the canvas 
		// allowing user to scroll the canvas
		// Also set size of the scroll panel
		JScrollPane canvaspanel = new JScrollPane(canvas);
		canvaspanel.setMinimumSize(new Dimension(500,400));
		canvaspanel.setPreferredSize(new Dimension(500,400));
		canvaspanel.setMaximumSize(new Dimension(500,400));
		// Set the layout and size of this panel
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(new Dimension(500,550));
		this.setPreferredSize(new Dimension(500,550));
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
		this.add(labels,constraint);
		constraint.gridy = 2;
		this.add(buttons, constraint);
		
	}

	/**
	 * This method runs the setStartlistener method in the button class
	 * which will set the ActionListener that it takes as input 
	 * to the appropriate button
	 * @param act is the actionListener
	 * @return a new population with the population assigned
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
	 * This method runs the setStoplistener method in the button class
	 * which will set the ActionListener that it takes as input 
	 * to the appropriate button
	 * @param act is the actionListener
	 * @return a new population with the population assigned
	 * @throws none
	 * <dt><b>Preconditions</b><dd>
	 * 			none
	 * <dt><b>Postconditions</b><dd>
	 * 			act is the actionListener to the stop button  
	 */
	public void setStopListener(ActionListener act) {
		this.buttons.setStoplistener(act);
	}		
	
	/* setResetListener: ActionListener --> void
	 * 
	 * This method runs the setResetlistener method in
	 * the Buttons class that will ultimately set the 
	 * ActionListener that it takes as input to the 
	 * appropriate button
	 */
	public void setResetListener(ActionListener act) {
		// Call setResetlistener
		this.buttons.setResetlistener(act);
	}
	
	/* setMouseListener: ActionListener --> void
	 * 
	 * This method adds the MouseListener that it
	 * takes as input to the canvas
	 */
	public void setMouseListener(MouseListener act) {
		// Add mouse listener
		this.canvas.addMouseListener(act);
	}
	
	/* updatecounter: --> void
	 * 
	 * This method runs the updatecounter method that is 
	 * in the label class
	 */
	public void updatecounter() {
		// Call method
		this.labels.updatecounter();
	}
	
	/* resetcounter: --> void
	 * 
	 * This method runs the resetcounter method that is
	 * in the label class
	 */
	public void resetcounter() {
		// Call method
		this.labels.resetcounter();
	}
	
	/* addloc: Point --> void
	 * 
	 * This method runs the addloc method that is in the 
	 * canvas class that ultimately adds the point that 
	 * it takes as input to the list of points that's in 
	 * the canvas class
	 */
	public void addloc(Point loc) {
		// Call method
		this.canvas.addloc(loc);
	}
	
	/* removeloc: Point --> void
	 * 
	 * This method runs the removeloc method that is in
	 * the canvas class that ultimately removes the point 
	 * that it takes as input from the array list of points
	 * that's in the canvas class
	 */
	public void removeloc(Point loc) {
		// Call method
		this.canvas.removeloc(loc);
	}
	
	/* removeall: --> void
	 * 
	 * This method calls the removeall method that is
	 * in the canvas class that ultimately removes all
	 * of the locs from the array list of locs that's
	 * in the canvas class
	 */
	public void removeall() {
		// Calling method in canvas
		this.canvas.removeall();
	}
	
	/* setNumbAlive: --> void
	 * 
	 * This method calls the setNumAlive method in the 
	 * label class and gives it the number of locs that
	 * are in the canvas, in order to set the number of
	 * alive cells on the appropriate label.
	 */
	public void setNumbAlive() {
		// Calling method in label class, passing number of locs
		this.labels.setNumAlive(this.canvas.numbLocs());
	}
	
	/* draw: --> void
	 * 
	 * This method repaints the canvas
	 */
	public void draw() {
		// Repaint
		this.canvas.repaint();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof ArrayList<?>) {
			ArrayList<Point> locs = (ArrayList<Point>) arg;
			// Set the locs
			this.canvas.setlocs(locs);
			// Repaint the canvas with those locs
			this.canvas.repaint();
		}
	}
}