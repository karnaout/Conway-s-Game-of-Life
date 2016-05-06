/*
 * Khaled Arnaout
 * Project 2 
 * StartControl 
 */
package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Start Button Controller
 */
public class StartControl implements ActionListener {

	private Population model;
	private MainView view;

	public StartControl(Population model, MainView view) {
		this.model = model;
		this.view = view;
		this.view.setStartListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.model.isRunning() && !this.model.isRandom()) {
			this.model.start();
			this.view.flip();
		}
		else{
			this.model.stop();
			this.view.flip();
		}
	}
}
