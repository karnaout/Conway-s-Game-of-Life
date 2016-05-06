/*
 * Khaled Arnaout
 * Project 2 
 * StopControl 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopControl implements ActionListener {
	
	private Population model;
	private View view;
	
	public StopControl(Population model, View view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Set this listener to the stop button
		this.view.setStopListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If the timer is running stop it
		if(this.model.isRunning()) {
			this.model.stop();
		}
	}
}
