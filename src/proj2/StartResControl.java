/*
 * Khaled Arnaout
 * Project 2 
 * StartResControl 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Start Random button Controller 
 */
public class StartResControl implements ActionListener {
	
	private Population model;
	private MainView view;

	public StartResControl(Population model, MainView view) {
		this.model = model;
		this.view = view;
		this.view.setStartRanListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 	if(!this.model.isRunning() && !this.model.isResurrecting()) {
			this.model.start();
			this.view.flip();
		}
		else{
			this.model.stop();
			this.view.flip();
		}
		 */
		if(!this.model.isRandom() && !this.model.isRunning()) {
			this.view.resetcounter();
			this.model.startRandom();
			this.view.Randomflip();
		}
		else{
			this.model.stopRandom();
			this.view.Randomflip();
		}
	}
}
