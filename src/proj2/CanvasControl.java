/*
 * Khaled Arnaout
 * Project 2 
 * CanvasControl 
 */
package proj2;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * CanvasController
 */
public class CanvasControl implements MouseListener {
	
	Population model;
	MainView view;
	private int SqaureSize;
	
	public CanvasControl(Population model, MainView view) {
		this.model = model;
		this.view = view;
		this.view.setMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// If the timer is not running & cells aren't being filled randomly
		if(!this.model.isRunning() && !this.model.isRandom()) {
			this.view.resetcounter(); // Reset counter
			Point ploc = e.getPoint(); // Where mouse clicked
			SqaureSize = this.view.getSquareSize();
			int column = ploc.x / SqaureSize; // Change pixel x loc to grid x loc
			int row = ploc.y / SqaureSize; // Change pixel y loc to grid y loc
			Point gloc = new Point(column,row); // Make a point
			if(!this.model.isAlive(row,column)) { // If dead
				// Bring back to life
				this.model.setAlive(row,column);
				// Add loc in the canvas
				this.view.addloc(gloc);
			}
			else { // If alive
				// Kill cell
				this.model.kill(row,column);
				// Remove loc from the canvas
				this.view.removeloc(gloc);
			}
			// Re-draw
			this.view.draw();
			// Recount alive cells
			this.view.setNumbAlive();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
