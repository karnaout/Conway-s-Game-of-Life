/*
 * Khaled Arnaout
 * Project 2 
 * ResetControl 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Reset Button Controller
 *
 */
public class ResetControl implements ActionListener {
	
	private Population model;
	private MainView view;
	
	public ResetControl(Population model, MainView view) {
		this.model = model;
		this.view = view;
		this.view.setResetListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.model.isRunning() && !this.model.isRandom()) {
			this.model.killcells();
			this.view.removeall();
			this.view.resetcounter();
			this.view.draw();
			this.view.setNumbAlive();
		}
	}
}
