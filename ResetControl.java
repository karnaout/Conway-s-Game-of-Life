/*
 * Khaled Arnaout
 * Project 2 
 * ResetControl 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResetControl implements ActionListener {
	
	private Population model;
	private View view;
	
	public ResetControl(Population model, View view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Set this listener to the reset button
		this.view.setResetListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If ticker is not running and cells aren't being resurrected
		if(!this.model.isRunning() /*&& !this.model.isResurrecting()*/) {
			// Kill all cells
			this.model.reset();
			// Remove locs of alive cells in the view
			this.view.removeall();
			// Reset counter
			this.view.resetcounter();
			// Re-draw
			this.view.draw();
			// Recount alive cells
			this.view.setNumbAlive();
		}
	}
}
