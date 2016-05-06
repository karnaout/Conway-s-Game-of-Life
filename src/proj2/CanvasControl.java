/*
 * Khaled Arnaout
 * Project 2 
 * CanvasController 
 */
package proj2;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CanvasControl implements MouseListener {
	
	Population model;
	View view;
	
	public CanvasControl(Population model, View view) {
		this.model = model;
		this.view = view;
		this.view.setMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// If the timer is not running
		if(!this.model.isRunning()) {
			this.view.resetcounter(); 
			Point ploc = e.getPoint();
			int column = ploc.x / 10; 
			int row = ploc.y / 10; 
			// Make a point
			Point gloc = new Point(column,row); 
			// If dead
			if(!this.model.isAlive(row,column)) { 
				// Bring back to life
				this.model.setState(row, column, true);
				// Add loc in the canvas
				this.view.addloc(gloc);
			}
			else { // If alive
				// Kill cell
				this.model.setState(row, column, false);
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
